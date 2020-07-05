package it.esedra.corso.marco;

public class DesktopPcFinal {

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
