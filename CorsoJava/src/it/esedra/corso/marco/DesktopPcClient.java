package it.esedra.corso.marco;

/**
 * Questa classe permette di settare i valori delle componenti del pc, e ritorna a schermo la configurazione scelta
 * @author marco
 *
 */
public class DesktopPcClient {

	public static void main(String[] args) {
		
		DesktopPcAssembly configuration = new DesktopPcAssembly();
		DesktopPcAssemblyAlerts reminder = new DesktopPcAssemblyAlerts();
		
		reminder.setMotherboardFormat("ATX");
		reminder.setMotherboardVendorName("MSI");
		reminder.setMotherboardCpuSocketType("AM4");
		reminder.setCpuVendorName("AMD");
		reminder.setCpuClock("4,4 GHz");
		configuration.setGraphicCardVendorName("nVidia");
		configuration.setGraphicsCardMemory("12 GB");
		configuration.setGraphicsCardChipType("GeForce GTX 980 Ti");
		configuration.setHddType("SSD");
		configuration.setHddCapacity("500 GB");
		
		System.out.println("=============================================================================================================================================================");
		System.out.println(reminder.getCoreAssembly());
		System.out.println("=============================================================================================================================================================");
		System.out.println(configuration.getGpuAssemblyExtended());
		System.out.println("=============================================================================================================================================================");
		System.out.println(configuration.getHardDrivesAssembly());
		System.out.println("=============================================================================================================================================================");
		
	}

}
