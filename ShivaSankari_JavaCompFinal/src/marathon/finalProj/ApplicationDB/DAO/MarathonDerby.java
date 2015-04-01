/**
 * 
 */
package marathon.finalProj.ApplicationDB.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import marathon.finalProj.ApplicationDB.Domain.Runner;

/**
 * This class is used to get the data of runners from the Derby data base.
 *
 */
public class MarathonDerby implements MarathonDAO {
	/**
	 * This method is responsible for creating a connection with the derby db
	 * 
	 * @return the connection to the derby
	 */
	private Connection getConnection() {
		Connection connection = null;
		try {
			// if necessary, set the home directory for Derby
			String dbDirectory = "resource";
			System.setProperty("derby.system.home", dbDirectory);

			// set the db url, username, and password
			String url = "jdbc:derby:MarathonDB";
			String username = "";
			String password = "";

			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

	/**
	 * This method get the runners information stored in the MarathonDB using a
	 * sql query. returns the arrayList of Runner.
	 * 
	 * @return the arraylist of runner object
	 */
	@Override
	public ArrayList<Runner> getRunners() {
		String sql = "SELECT RunnersName, RunnersSpeed, RestPercentage "
				+ "FROM Runners";
		ArrayList<Runner> runners = new ArrayList<>();
		// query the DB and get the result set and add it as the Runner object
		// in the runners array list
		try (Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) // prevent the SQL Exception
		{
			while (rs.next()) {
				String name = rs.getString("RunnersName");
				int speed = (int) rs.getDouble("RunnersSpeed");
				int rest = (int) rs.getDouble("RestPercentage");

				Runner r = new Runner(name, speed, rest);
				runners.add(r);
			}
			return runners;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

}
