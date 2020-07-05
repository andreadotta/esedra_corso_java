package it.esedra.corso.marco;

public class DesktopPcAssemblyAlerts extends DesktopPc {
	
	public String getMotherboardCpuSocketType() {
		return "Motherboard CPU Socket Type: " + this.motherboardCpuSocketType + " (!!! Check for compatibility with the CPU socket !!!)";
	}
	
	public String getCoreAssembly() {
		
		return "PC's Core Assembly ===> " + getMotherboardFormat() + " - " + getMotherboardVendorName() + " - " + this.getMotherboardCpuSocketType() + " - " + getCpuVendorName() + " - " + getCpuClock();
	
	}

}