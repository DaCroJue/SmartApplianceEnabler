import {Selector} from 'testcafe';
import {saeRestartTimeout} from '../shared/timeout';
import {TopMenu} from './top-menu.page';
import {clickButton} from '../shared/form';
import {
  waitForApplianceToExist,
  waitForControlToExist,
  waitForMeterToExist,
  waitForSchedulesToExist,
  waitForStatusToExist
} from '../shared/helper';

export class SideMenu {

  private static SETTINGS_SELECTOR = 'app-sidenav a[href="/settings"]';
  private static STATUS_SELECTOR = 'app-sidenav a[href="/status"]';

  private static async openSideMenuIfClosed(t: TestController) {
    const sideMenuOpen = await Selector('mat-sidenav.mat-drawer-opened').exists;
    if (! sideMenuOpen) {
      await TopMenu.clickMenu(t);
      await Selector('mat-sidenav.mat-drawer-opened').exists;
    }
    await t.wait(500);
  }

  public static async clickSettings(t: TestController) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.SETTINGS_SELECTOR);
  }

  public static async clickStatus(t: TestController) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.STATUS_SELECTOR);
    await waitForStatusToExist();
  }

  public static newAppliance(): string {
    return 'a[href="/appliance"]';
  }

  public static async clickNewAppliance(t: TestController) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.newAppliance());
  }

  public static appliance(id: string): string {
    return `a[href="/appliance/${id}"]`;
  }

  public static async clickAppliance(t: TestController, id: string) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.appliance(id), {timeout: saeRestartTimeout});
    await waitForApplianceToExist();
  }

  public static meter(id: string): string {
    return `a[href="/meter/${id}"]`;
  }

  public static async clickMeter(t: TestController, id: string) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.meter(id), {timeout: saeRestartTimeout});
    await waitForMeterToExist();
  }

  public static control(id: string): string {
    return `a[href="/control/${id}"]`;
  }

  public static async clickControl(t: TestController, id: string) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.control(id), {timeout: saeRestartTimeout});
    await waitForControlToExist();
  }

  public static schedule(id: string): string {
    return `a[href="/schedule/${id}"]`;
  }

  public static async clickSchedule(t: TestController, id: string) {
    await SideMenu.openSideMenuIfClosed(t);
    await clickButton(t, SideMenu.schedule(id), {timeout: saeRestartTimeout});
    await waitForSchedulesToExist();
  }
}
