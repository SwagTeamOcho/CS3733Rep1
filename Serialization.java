import java.io.*;

public class Serialization {
	
	// saves Map object "m" in a file named "s"
	public void serialize(String s, Map m){
		
		try
		{
			FileOutputStream fileOut = new FileOutputStream(s + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(m);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in " + s + ".ser");
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	
	// loads the map stored in file name "s"
	public Map deserialize(String s){
		Map m = null;
		try
		{
			FileInputStream fileIn = new FileInputStream(s + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			m = (Map) in.readObject();
			in.close();
			fileIn.close();
		}catch(IOException i)
		{
			i.printStackTrace();

		}catch(ClassNotFoundException c)
		{
			System.out.println("Map class not found");
			c.printStackTrace();
	
		}
		System.out.println("Deserialized map...");
		System.out.println("Name: " + m.getMapName());
	return m;
	}
}
