
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlite {

public static void main(String[] args) throws Exception{
Class.forName("org.sqlite.JDBC");
Connection bd = DriverManager.getConnection("jdbc:sqlite:sqlite.db3");
Statement st = bd.createStatement();
//st.execute("drop table 'TABLE1'");
st.execute("create table if not exists 'TABLE1' ('id' integer PRIMARY KEY AUTOINCREMENT NOT NULL,'привет' text, 'оу' text, 'хорошо' text);");
String s ="insert into 'TABLE1' ('привет', 'оу', 'хорошо') values ('test', 'name1', 'name2'); ";
System.out.println(s);
st.execute("insert into 'TABLE1' ('привет', 'оу', 'хорошо') values ('test', 'name1', 'name2'); ");
st.execute("insert into 'TABLE1' ('привет', 'оу', 'хорошо') values ('test', 'name3', 'name4'); ");
st.execute("insert into 'TABLE1' ('привет', 'оу', 'хорошо') values ('TEST', 'name5', 'name6');");
ResultSet rs = st.executeQuery("select * from TABLE1");
while (rs.next())
{
System.out.print (rs.getString(1)+" ");
System.out.print (rs.getString(2)+" ");
System.out.print (rs.getString(3)+" ");
System.out.println(rs.getString(4));
}
bd.close();
st.close();
rs.close();

}

}