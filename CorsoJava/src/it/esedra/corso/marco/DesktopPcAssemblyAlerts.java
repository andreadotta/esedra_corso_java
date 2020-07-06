package it.esedra.corso.marco;

public class DesktopPcAssemblyAlerts extends DesktopPcAssembly {
	
	public String getMotherboardCpuSocketType() {
		return "Motherboard CPU Socket Type: " + this.motherboardCpuSocketType + " (!!! Check for compatibility with the CPU socket !!!)";
	}
	
}