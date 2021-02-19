package Google_HashCode.hashCodeSolution;

//---------------------------//

//Team name - A Team Of Sorts//
//---------------------------//

// Imports & Packages

public class Drone {

	// Attributes
	private static int droneProducts[];
	private static String droneLocation;
	private static int droneCurLoad;
	private int droneID;
	private int maxLoad;

	// Class Variables
	private static int lastdroneID = 0; // used to remember the last drone ID assigned

	// Drone Constructor
	public Drone(int maxLoad) {
		// Initialize attributes with values provided
		lastdroneID++;
		droneCurLoad = 0;
		droneID = lastdroneID;
		droneProducts = new int[hashCodeSolution.product.length];
		droneLocation = hashCodeSolution.dStartLoc;
		this.maxLoad = maxLoad;
	}

	public int Load(int Q, int order, int type, String whLocation[], int W) {
		int T = 0;// stores the number of turns this load has used
		if (order == 0) {
			return 0;
		}
		if (!droneLocation.equals(whLocation[W])) {
			T += Move(droneLocation, whLocation[W]);
		}
		if (order <= hashCodeSolution.warehouse[W][type]
				&& hashCodeSolution.product[type] * order <= maxLoad - droneCurLoad) { // if there's enough items in the
																						// warehouse and there's enough
																						// space on
																						// the drone
			droneProducts[type] += order;
			hashCodeSolution.command[Q] = droneID + " L " + W + " " + type + " " + order;
			Q++;
			droneCurLoad += hashCodeSolution.product[type] * order;
			order = 0;
			hashCodeSolution.warehouse[W][type] -= order;

		} else if (!(order <= hashCodeSolution.warehouse[W][type])
				&& hashCodeSolution.product[type] * order <= maxLoad - droneCurLoad) {// if there's not enough items in
																						// the
																						// warehouse and there's enough
																						// space on
																						// the drone
			droneProducts[type] += hashCodeSolution.warehouse[W][type];
			hashCodeSolution.command[Q] = droneID + " L " + W + " " + type + " " + hashCodeSolution.warehouse[W][type];
			Q++;
			droneCurLoad += hashCodeSolution.product[type] * hashCodeSolution.warehouse[W][type];
			order -= hashCodeSolution.warehouse[W][type];
			hashCodeSolution.warehouse[W][type] = 0;// because you just took all the remaining items in it
			int closest[] = new int[whLocation.length];
			for (int i = 0; i < hashCodeSolution.warehouse.length; i++) {
				if (order <= hashCodeSolution.warehouse[W][type]) {
					String array[] = whLocation[i].split(" ");
					String curLoc[] = droneLocation.split(" ");
					int distance = (int) Math
							.sqrt(Math.pow(Math.abs(Integer.parseInt(array[0]) - Integer.parseInt(curLoc[0])), 2)
									+ Math.pow(Math.abs(Integer.parseInt(array[1]) - Integer.parseInt(curLoc[1])), 2));
					closest[i] = distance;
				}
			}
			int temp = hashCodeSolution.R * hashCodeSolution.C;
			int index = 0;
			for (int i = 0; i < closest.length; i++) {
				if (closest[i] < temp) {
					temp = closest[i];
					index = i;
				}
			}
			System.out.println(Q + ", " + order + ", " + type + " " + whLocation[index]);
			T += Move(droneLocation, whLocation[index]);
			droneProducts[type] += hashCodeSolution.warehouse[index][type];
			hashCodeSolution.command[Q] = droneID + " L " + W + " " + type + " "
					+ hashCodeSolution.warehouse[index][type];
			Q++;
			droneCurLoad += hashCodeSolution.product[type] * hashCodeSolution.warehouse[index][type];
			order -= hashCodeSolution.warehouse[index][type];
			hashCodeSolution.warehouse[index][type] = 0;// because you just took all the remaining items in it
		}
		return T + 1;
	}

	public int Deliver(int order[], String destination) {
		for (int i = 0; i < order.length; i++) {
			order[i] -= droneProducts[i];
			droneCurLoad -= droneProducts[i] * hashCodeSolution.product[i];
			droneProducts[i] = 0;
		}
		int T = Move(droneLocation, destination);
		return T + 1;
	}

	public int Move(String currentLo, String destination) {
		String[] cur = currentLo.split(" ");
		String[] des = destination.split(" ");
		droneLocation = destination;
		int T = (int) Math.sqrt(Math.pow(Math.abs(Integer.parseInt(cur[0]) - Integer.parseInt(des[0])), 2)
				+ Math.pow(Math.abs(Integer.parseInt(cur[1]) - Integer.parseInt(des[1])), 2));
		return T;
	}
}
