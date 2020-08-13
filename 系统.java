package mange;
import java.sql.*;
import java.util.Scanner;
public class 系统 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/lianxi?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT&allowPublicKeyRetrieval=true";
    static final String USER = "root";
    static final String PASS = "13591166720xin";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql;
    public  void menu()
    {
        Scanner scan=new Scanner(System.in);
        int choice;
        System.out.print("----------------\n");
        System.out.print(" 1.查询员工信息\n");
        System.out.print(" 2.删除员工信息\n");
        System.out.print(" 3.增加员工信息\n");
        System.out.print(" 4.修改员工信息\n");
        System.out.print(" 5.退出系统\n");
        System.out.print("----------------\n");
        System.out.print("输入选项：");
        choice = scan.nextInt();
        switch(choice)
        {
            case 1:chaxun();break;
            case 2:delete();break;
            case 3:add();break;
            case 4:gai();break;
            default:System.out.print("您已退出，再见");System.exit(0);
        }

    }


    public void chaxun () {
       try {
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();
           Scanner scan = new Scanner(System.in);
           System.out.print("查询方式：1.查询全部员工信息  2.查询某个员工信息\n");
           System.out.print("输入选项：");
           int choice1 = scan.nextInt();
           if (choice1 == 1) {
               sql = "select id,name,age,salary,department from employee";
               rs = stmt.executeQuery(sql);
               while (rs.next()) {

                   int id = rs.getInt("id");
                   String name = rs.getString("name");
                   int age = rs.getInt("age");
                   int salary = rs.getInt("salary");
                   int department = rs.getInt("department");
                   System.out.println("员工工号：" + id);
                   System.out.println("员工名字：" + name);
                   System.out.println("员工年龄：" + age);
                   System.out.println("员工工资：" + salary);
                   System.out.println("所属部门：" + department);
                   System.out.print("\n");
               }


           } else {
               System.out.print("1.id查询 2.名字查询\n");
               System.out.print("输入选项：");
               int choice2 = scan.nextInt();
               if (choice2 == 1) {
                   System.out.print("输入id：");
                   int checkid = scan.nextInt();
                   sql = "select id,name,age,salary,department from employee";
                   rs = stmt.executeQuery(sql);
                   while (rs.next()) {

                       int id = rs.getInt("id");
                       String name = rs.getString("name");
                       int age = rs.getInt("age");
                       int salary = rs.getInt("salary");
                       int department = rs.getInt("department");
                       if (id == checkid) {
                           System.out.println("员工工号：" + id);
                           System.out.println("员工名字：" + name);
                           System.out.println("员工年龄：" + age);
                           System.out.println("员工工资：" + salary);
                           System.out.println("所属部门：" + department);
                       }
                   }
               }
           }
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }
    public void delete()
    {
       try {
           Class.forName(JDBC_DRIVER);
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();
           Scanner scan = new Scanner(System.in);
           System.out.print("输入员工id：");
           int a = scan.nextInt();
           sql = "delete from employee where id="+a+"";
           int i = stmt.executeUpdate(sql);
           if (i == 1) {
               System.out.print("删除成功\n");
           } else {
               System.out.print("删除失败\n");
           }
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }
    public void add()
    {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入员工信息\n");
            System.out.print("员工id：");
            int addid = scan.nextInt();
            System.out.print("员工名字：");
            String addname = scan.next();
            System.out.print("员工年龄：");
            int addage = scan.nextInt();
            System.out.print("员工工资：");
            int addsalary = scan.nextInt();
            System.out.print("员工部门：");
            int adddepartment = scan.nextInt();
            sql = "insert into employee(id,name,age,salary,department)value(" + addid + ",'" + addname + "'," + addage + "," + addsalary + "," + adddepartment + ")";
            int j = stmt.executeUpdate(sql);
            if (j == 1) {
                System.out.print("添加成功\n");
            } else {
                System.out.print("添加失败\n");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void gai()
    {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入修改后员工信息\n");
            System.out.print("要修改的员工id：");
            int gid = scan.nextInt();
            System.out.print("修改后员工名字：");
            String gname = scan.next();
            System.out.print("修改后员工年龄：");
            int gage = scan.nextInt();
            System.out.print("修改后员工工资：");
            int gsalary = scan.nextInt();
            System.out.print("修改后员工部门：");
            int gp = scan.nextInt();
            sql = "update employee set name='" + gname + "',age=" + gage + ",salary=" + gsalary + ",department=" + gp + " where id=" + gid + "";
            int k = stmt.executeUpdate(sql);
            if (k == 1) {
                System.out.print("修改成功\n");
            } else {
                System.out.print("修改失败\n");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public  static void main(String[] args) {

        while(true)
        {
            new 系统().menu();
        }

    }
}
