package it.esedra.corso.marco.desktopPc;

/**
 * Questa classe contiene override dei metodi della classe DesktopPcAssemnly, e permette di ridefinirne i metodi per aggiungere reminders e alerts
 * @author marco
 *
 */
public class DesktopPcAssemblyAlerts extends DesktopPcAssembly {
	
	public String getMotherboardCpuSocketType() {
		return "Motherboard CPU Socket Type: " + this.motherboardCpuSocketType + " (!!! Check for compatibility with the CPU socket !!!)";
	}
	
}