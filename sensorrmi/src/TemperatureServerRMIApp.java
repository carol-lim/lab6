import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ftmk.rmi.sensor.TemperatureSensor;
import ftmk.rmi.sensor.manager.TemperatureSensorManager;

/**
 * This class represent the server-side application using RMI
 * @author emalianakasmuri
 *
 */
public class TemperatureServerRMIApp {

	public static void main(String[] args) {
		try {
			// Create interface object
			TemperatureSensor sensorJasin = new TemperatureSensorManager();
			
			// Lab6Exercise2: Register a new remote object that represent the sensor in Ayer Keroh.
			TemperatureSensor sensorAyerKeroh = new TemperatureSensorManager();
		
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry();
			
			// Register interface object as remote object
			rmiRegistry.rebind("SensorJasin", sensorJasin);
			System.out.println("SensorJasin is successfully registered");
			
			rmiRegistry.rebind("AyerKeroh", sensorAyerKeroh);
			System.out.println("SensorAyerKeroh is successfully registered");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
