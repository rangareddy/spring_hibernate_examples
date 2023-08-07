/**
  * Created by Ranga_Reddy1 on 3/3/2017.
  */

import java.sql.{Connection, DriverManager, Statement}

import com.typesafe.config.ConfigFactory

object ScalaJDBCExample {

  // Declaring constants
  val DRIVER_CLASS = "driverClass";
  var URL ="url";
  var USER_NAME = "username";
  var PASSWORD = "password";

  var SELECT_QUERY = "SELECT first_name, last_name, salary FROM employees LIMIT 20";


  // Declaring connection object
  var connection : Connection = null;

  def main(args: Array[String]): Unit = {
      var statement = getStatement;
      var resultSet = statement.executeQuery(SELECT_QUERY);
      while(resultSet.next()) {
        val firstName = resultSet.getString(1);
        val lastName = resultSet.getString(2);
        val salary = resultSet.getDouble(3);

        println("First Name: "+firstName+", Last Name: "+lastName+", Salary: "+salary);
      }
  }

  def getStatement: Statement = {
    return getConnection.createStatement();
  }

  def getConnection : Connection = {
    if(connection == null) {

      var props = ConfigFactory.load();
      require(props.getString(DRIVER_CLASS) != null, "Driver class is required.");
      Class.forName(props.getString(DRIVER_CLASS));

      require(props.getString(URL) != null, "Url is required.");
      require(props.getString(USER_NAME) != null, "Username is required.");
      require(props.getString(PASSWORD) != null, "Password is required.");

      connection = DriverManager.getConnection(props.getString(URL), props.getString(USER_NAME), props.getString(PASSWORD));
    }
    return connection;
  }
}
