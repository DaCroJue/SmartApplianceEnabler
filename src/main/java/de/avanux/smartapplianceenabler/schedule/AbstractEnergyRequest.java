/*
 * Copyright (C) 2020 Axel Müller <axel.mueller@avanux.de>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package de.avanux.smartapplianceenabler.schedule;

import de.avanux.smartapplianceenabler.control.ev.EVChargerState;
import de.avanux.smartapplianceenabler.control.ev.ElectricVehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;

@XmlTransient
abstract public class AbstractEnergyRequest extends AbstractRequest {

    private transient boolean updateTimeframeIntervalEnd;
    private transient EVChargerState evChargerState;

    public AbstractEnergyRequest() {
        setEnabled(false);
    }

    protected Logger getLogger() {
        return LoggerFactory.getLogger(AbstractEnergyRequest.class);
    }


    public void setUpdateTimeframeIntervalEnd(boolean updateTimeframeIntervalEnd) {
        this.updateTimeframeIntervalEnd = updateTimeframeIntervalEnd;
    }

    public boolean isUpdateTimeframeIntervalEnd() {
        return updateTimeframeIntervalEnd;
    }

    public EVChargerState getEvChargerState() {
        return evChargerState;
    }

    @Override
    public void onEVChargerStateChanged(LocalDateTime now, EVChargerState previousState, EVChargerState newState,
                                        ElectricVehicle ev) {
        this.evChargerState = newState;
        if(newState == EVChargerState.VEHICLE_CONNECTED && ev.getSocScript() == null) {
            setEnabled(true);
        }
        else if(isActive() && (newState == EVChargerState.VEHICLE_NOT_CONNECTED || newState == EVChargerState.CHARGING_COMPLETED)) {
            setEnabled(false);
        }
    }

}
