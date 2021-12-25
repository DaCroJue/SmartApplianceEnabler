/*
 * Copyright (C) 2017 Axel Müller <axel.mueller@avanux.de>
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

package de.avanux.smartapplianceenabler.meter;

import de.avanux.smartapplianceenabler.modbus.ModbusElectricityMeterDefaults;
import de.avanux.smartapplianceenabler.modbus.ModbusReadDefaults;

import java.util.HashMap;
import java.util.Map;

public class MeterDefaults {
    S0ElectricityMeterDefaults s0ElectricityMeterDefaults = new S0ElectricityMeterDefaults();
    HttpElectricityMeterDefaults httpElectricityMeterDefaults = new HttpElectricityMeterDefaults();
    ModbusElectricityMeterDefaults modbusElectricityMeterDefaults = new ModbusElectricityMeterDefaults();
    ModbusReadDefaults modbusReadDefaults = new ModbusReadDefaults();
    Map<String, String> masterElectricityMeterApplianceIdWithApplianceName = new HashMap();

    public MeterDefaults(Map<String, String> masterElectricityMeterApplianceIdWithApplianceName) {
        this.masterElectricityMeterApplianceIdWithApplianceName = masterElectricityMeterApplianceIdWithApplianceName;
    }
}
