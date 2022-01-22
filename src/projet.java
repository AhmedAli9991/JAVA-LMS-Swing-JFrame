import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class projet {

	public static void main(String[] args) {
		form abc =new form();

	}

}
class form extends JFrame{
	String[]student_name;
	String[]student_reg_no;
	String[]student_passwords;
	String[]teacher_name;
	String[]Courses;
	String[]teacher_passwords;
	String[][][]student_quiz_marks;
	String[][][]student_assignment_marks;
	String admin_name="HOD";
	String admin_ID="111";
	String admin_password="password";
	String[]chatteacher;
	String[]chatstudent;
	int quiz_index;
	int assignment_index;
	int course_index;
	public form(){
		JRadioButton std = new JRadioButton("Student");
		JRadioButton prof = new JRadioButton("Teacher");
		JRadioButton admin = new JRadioButton("Administration");
		JButton submit = new JButton("Submit");
		ButtonGroup bg = new ButtonGroup();
		bg.add(std);
		bg.add(prof);
		bg.add(admin);
		add(std);
		add(prof);
		add(admin);
		add(submit);
		File chat1 = new File("techerchat.txt");
		File chat2 = new File("studentchat.txt");
		File chatstdTest = new File("studentchattest.txt");
		File chatteachtest = new File("teacherchattest");
		if(!chat1.exists()) {
		try {
			PrintWriter out0 = new PrintWriter(chat1);
			out0.println("hello");
			out0.close();
			PrintWriter out1 = new PrintWriter(chat2);
			out1.println("hello");
			out1.close();
			PrintWriter out2 = new PrintWriter(chatstdTest);
			out2.println("test");
			out2.close();
			PrintWriter out3 = new PrintWriter(chatteachtest);
			out3.println("test");
			out3.close();
		}catch(IOException exa) {}}
		submit.addActionListener(e->{
			if(std.isSelected()) {
				studentlogin x = new studentlogin ();
				dispose();}
			else if(prof.isSelected()){
				teacherlogin x = new teacherlogin();
				dispose();}
			else if(admin.isSelected()) {
				adminlogin x = new adminlogin();
				dispose();}
		});
		setVisible(true);
		setSize(750,700);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

	class studentlogin extends JFrame{
		public studentlogin() {
			JLabel l1 = new JLabel("Name");
			JTextField name = new JTextField(70);
			JLabel r1 = new JLabel("");
			JLabel l2 = new JLabel("registration number");
			JTextField reg = new JTextField(70);
			JLabel r2 = new JLabel("");
			JLabel l3 = new JLabel("password");
			JPasswordField pass = new JPasswordField(70);
			JLabel r3 = new JLabel("");
			JButton log=new JButton("Login");
			JButton back = new JButton ("Back");
			JButton msg  = new JButton("Message");
			add(l1);
			add(name);
			add(r1);
			add(l2);	
			add(reg);
			add(r2);
			add(l3);
			add(pass);
			add(r3);
			add(back);
			add(log);
			add(msg);
			msg.addActionListener(e->{
				studentmsg sm = new studentmsg();
			});
			back.addActionListener(e->{
				form n = new form();
				dispose();
			});
			log.addActionListener(e->{
				File student_Name = new File("student name.txt");
				File student_registration = new File("student registration number.txt");
				File student_pass = new File("student passwords.txt");
				File student_test = new File("student test.txt");
				try{
					int count=0;
					Scanner in = new Scanner(student_test);
					while(in.hasNextLine()) {
						String a = in.nextLine();
						count++;
					}
					student_name = new String[count];
					student_reg_no = new String[count];
					student_passwords = new String[count];
					in.close();
					Scanner in0 = new Scanner(student_Name);
					int j=0;
					while(in0.hasNextLine()) {
						student_name[j] =in0.nextLine();
						j++;
					}
					in0.close();
				
					Scanner in1 = new Scanner(student_registration);
				
					int k=0;
					while(in1.hasNextLine()) {
						student_reg_no[k] =in1.nextLine();
						k++;
					}
					in1.close();
					Scanner in2 = new Scanner(student_pass);
					int l=0;
					while(in2.hasNextLine()) {
						student_passwords[l] =in2.nextLine();
						l++;
					}
					in2.close();}catch(FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "admin has not yet registered anyone");}
				String nm = name.getText();
				String rg = reg.getText();
				String ps = pass.getText();
				for(int i=0;i<student_name.length;i++) {
					if(student_name[i].equals(nm)&&student_reg_no[i].equals(rg)&&student_passwords[i].equals(ps)) {
						quiz_index = i;
						assignment_index = i;
						student ab = new student();
						dispose();
					}
				}
				int a=0;
				int b=0;
				int c=0;
				for(String i:student_name) {
					if(i.equals(nm))
						a=1;
				}
				for(String i:student_reg_no) {
					if(i.equals(rg))
						b=1;
				}
				for(String i:student_passwords) {
					if(i.equals(ps))
						c=1;
				}
				if(a==0)
					r1.setText("Invalid name");
				if(b==0)
					r2.setText("Invalid registration number");
				if(c==0)
					r3.setText("Invalid password");
				
			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	class teacherlogin extends JFrame{
		public teacherlogin() {
			JLabel l1 = new JLabel("Name");
			JTextField name = new JTextField(70);
			JLabel r1 = new JLabel("");
			JLabel l2 = new JLabel("Course");
			JTextField reg = new JTextField(70);
			JLabel r2 = new JLabel("");
			JLabel l3 = new JLabel("password");
			JPasswordField pass = new JPasswordField(70);
			JLabel r3 = new JLabel("");
			JButton log=new JButton("Login");
			JButton back = new JButton ("Back");
			JButton msg =  new JButton("Message");
			add(l1);
			add(name);
			add(r1);
			add(l2);	
			add(reg);
			add(r2);
			add(l3);
			add(pass);
			add(r3);
			add(back);
			add(log);
			add(msg);
			msg.addActionListener(e->{
				teachermsg tm = new teachermsg();
			});
			back.addActionListener(e->{
				form n = new form();
				dispose();
			});
			log.addActionListener(e->{
				File teacher_Name = new File("teacher name.txt");
				File courses = new File("course offered.txt");
				File teacher_pass = new File("teacher passwords.txt");
				File teacher_test = new File("teacher test.txt");
				try{
					int count=0;
					Scanner in = new Scanner(teacher_test);
					while(in.hasNextLine()) {
						String a = in.nextLine();
						count++;
					}
					teacher_name = new String[count];
					Courses = new String[count];
					teacher_passwords = new String[count];
					in.close();
					Scanner in0 = new Scanner(teacher_Name);
					int j=0;
					while(in0.hasNextLine()) {
						teacher_name[j] =in0.nextLine();
						j++;
					}
					in0.close();
					Scanner in1 = new Scanner(courses);
					int k=0;
					while(in1.hasNextLine()) {
						Courses[k] =in1.nextLine();
						k++;
					}
					in1.close();
					Scanner in2 = new Scanner(teacher_pass);
					int l=0;
					while(in2.hasNextLine()) {
						teacher_passwords[l] =in2.nextLine();
						l++;
					}
					in2.close();
				}catch(FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null,"admin has not registered teachers yet");
					dispose();
				}
				String nm = name.getText();
				String rg = reg.getText();
				String ps = pass.getText();
				for(int i=0;i<teacher_name.length;i++) {
					if(teacher_name[i].equals(nm)&&Courses[i].equals(rg)&&teacher_passwords[i].equals(ps)) {
						course_index = i;
						teacher ab = new teacher();
						dispose();
					}
				}
				int a=0;
				int b=0;
				int c=0;
				for(String i:teacher_name) {
					if(i.equals(nm))
						a=1;
				}
				for(String i:Courses) {
					if(i.equals(rg))
						b=1;
				}
				for(String i:teacher_passwords) {
					if(i.equals(ps))
						c=1;
				}
				if(a==0)
					r1.setText("Invalid name");
				if(b==0)
					r2.setText("Invalid ID number");
				if(c==0)
					r3.setText("Invalid password");
				
			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	class adminlogin extends JFrame{
		public adminlogin() {
			JLabel l1 = new JLabel("Name");
			JTextField name = new JTextField(70);
			JLabel r1 = new JLabel("");
			JLabel l2 = new JLabel("ID   ");
			JTextField reg = new JTextField(70);
			JLabel r2 = new JLabel("");
			JLabel l3 = new JLabel("password");
			JPasswordField pass = new JPasswordField(70);
			JLabel r3 = new JLabel("");
			JButton log=new JButton("Login");
			JButton back = new JButton ("Back");
			add(l1);
			add(name);
			add(r1);
			add(l2);	
			add(reg);
			add(r2);
			add(l3);
			add(pass);
			add(r3);
			add(back);
			add(log);
			back.addActionListener(e->{
				form n = new form();
				dispose();
			});
			log.addActionListener(e->{
				String nm = name.getText();
				String rg = reg.getText();
				String ps = pass.getText();
				int a=0;
				int b=0;
				int c=0;
				
				if(nm.equals(admin_name))
					a=1;
				else
					r1.setText("Invalid name");
				
				
				if(rg.equals(admin_ID))
					b=1;
				else
					r2.setText("Invalid ID");
				
				
				if(ps.equals(admin_password))
					c=1;
				else
					r3.setText("Invalid password");
				
				if(a==1&&b==1&&c==1) {
					admin ab = new admin();
					dispose();
				}
			});
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	
	class student extends JFrame{
		public student() {
			File courses = new File("course offered.txt");
			File teacher_test = new File("teacher test.txt");
			File student_Name = new File("student name.txt");
			int count=0;
			int count1=0;
			try {
			Scanner in = new Scanner(teacher_test);
			while(in.hasNextLine()) {
				String a = in.nextLine();
				count++;
			}
			in.close();
			Courses = new String[count];
			Scanner in0 = new Scanner(courses);
			for(int i=0;i<count;i++) {
				Courses[i]=in0.nextLine();
			}
			in0.close();
			Scanner in1 = new Scanner(student_Name);
			while(in1.hasNextLine()) {
				String a = in1.nextLine();
				count1++;
				}
			in1.close();
			}catch(FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "admin has not registerd course yet");
			}
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			add(u);
			JPanel[]P=new JPanel[Courses.length];
			JRadioButton[]RB=new JRadioButton[Courses.length];
			JButton check = new JButton("Check");
			ButtonGroup bg = new ButtonGroup();
			for(int i=0;i<RB.length;i++) {
				RB[i]=new JRadioButton(Courses[i]);
				bg.add(RB[i]);
				P[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
				P[i].add(RB[i]);
				add(P[i]);
			}
			JPanel c =new JPanel();
			c.add(check);
			add(c);
			student_quiz_marks = new String[count][count1][4]; 
			student_assignment_marks = new String[count][count1][4];
			u.setBackground(Color.GRAY);
			back.addActionListener(e->{
				studentlogin n = new studentlogin();
				dispose();
			});
			lout.addActionListener(e->{
				studentlogin n = new studentlogin();
				dispose();
			});
			check.addActionListener(e->{
				for(int i=0;i<RB.length;i++) {
					if(RB[i].isSelected()) {
						course_index = i;
						dispose();
						view ab = new view();
						
					}
				}
			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	class view extends JFrame{
		public view() {
			JLabel[]q = new JLabel[4];
			JLabel[]qm = new JLabel[4];
			JLabel[]qt = new JLabel[4];
			JLabel[]a = new JLabel[4];
			JLabel[]am = new JLabel[4];
			JLabel[]at = new JLabel[4];
			int c=1;
			for(int i=0;i<4;i++) {
				q[i]=new JLabel("Quiz "+c);
				a[i]=new JLabel("assignment "+c);
				qt[i]=new JLabel("10");
				at[i]=new JLabel("10");
				c++;
			}
			File quiz_marks = new File("quiz marks.txt");
			File assignment_marks = new File("assignment marks.txt");
			try {
				Scanner in0 = new Scanner(quiz_marks);
				for(int i=0;i<student_quiz_marks.length;i++) {
					for(int j=0;j<student_quiz_marks[i].length;j++) {
						for(int k=0;k<4;k++) {
							student_quiz_marks[i][j][k] = in0.nextLine();
						}
					}
				}
				in0.close();
				Scanner in1 = new Scanner(assignment_marks);
				for(int i=0;i<student_assignment_marks.length;i++) {
					for(int j=0;j<student_assignment_marks[i].length;j++) {
						for(int k=0;k<4;k++) {
							student_assignment_marks[i][j][k] = in1.nextLine();
						}
					}
				}
				in1.close();

			}catch(FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "No Marks have been uploaded yet");
			}
			for(int i=0;i<4;i++) {
				String marks = student_quiz_marks[course_index][quiz_index][i]; 
				qm[i] = new JLabel(marks+"/");
			}
			for(int i=0;i<4;i++) {
				String marks = student_assignment_marks[course_index][assignment_index][i]; 
				am[i] = new JLabel(marks+"/");
			}
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			add(u);

			JPanel[]p1 = new JPanel[4];
			JPanel qq = new JPanel();
			JLabel quiz= new JLabel("Quiz Marks");
			qq.add(quiz);
			for(int i=0;i<4;i++) {
				p1[i] = new JPanel();
				p1[i].add(q[i]);
				p1[i].add(qm[i]);
				p1[i].add(qt[i]);
			}
			add(qq);
			add(p1[0]);
			add(p1[1]);
			add(p1[2]);
			add(p1[3]);
			JPanel[]p2 = new JPanel[4];
			JPanel aa = new JPanel();
			JLabel assignments= new JLabel("Assignment Marks");
			aa.add(assignments);
			for(int i=0;i<4;i++) {
				p2[i] = new JPanel();
				p2[i].add(a[i]);
				p2[i].add(am[i]);
				p2[i].add(at[i]);
			}
			add(aa);
			add(p2[0]);
			add(p2[1]);
			add(p2[2]);
			add(p2[3]);
			u.setBackground(Color.GRAY);
			qq.setBackground(Color.PINK);
			aa.setBackground(Color.ORANGE);
			
			back.addActionListener(e->{
				student n = new student();
				dispose();
			});
			lout.addActionListener(e->{
				studentlogin n = new studentlogin();
				dispose();
			});
			
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setVisible(true);
			setSize(750,700);			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}

	class teacher extends JFrame{
		public teacher() {
			File student_Name = new File("student name.txt");
			File student_test = new File("student test.txt");
			try {
			Scanner in = new Scanner(student_test);
			int count=0;
			while(in.hasNextLine()) {
				String a = in.nextLine();
				count++;
			}
			in.close();
			student_name = new String[count];
			Scanner in0 = new Scanner(student_Name);
			for(int i=0;i<count;i++) {
				student_name[i]=in0.nextLine();
			}
			in0.close();
			}catch(FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "admin has not registerd teachers yet");
			}
			JRadioButton[]RB=new JRadioButton[student_name.length];
			JButton update = new JButton("Update");
			ButtonGroup bg = new ButtonGroup();
			JPanel[]P = new JPanel[student_name.length+1];
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			add(u);
			
			for(int i=0;i<RB.length;i++) {
				RB[i]=new JRadioButton(student_name[i]);
				bg.add(RB[i]);
				P[i]=new JPanel(new FlowLayout(FlowLayout.LEFT));
				P[i].add(RB[i]);
				add(P[i]);
			}
			P[student_name.length] = new JPanel();
			P[student_name.length].add(update);
			add(P[student_name.length]);
			int count = 0;
			File courses = new File("course offered.txt");
			try {
				Scanner in = new Scanner(courses);
				while(in.hasNext()) {
					String a = in.nextLine();
					count++;
				}in.close();
			}catch(FileNotFoundException ex) {	}
			student_quiz_marks=new String [count][RB.length][4];
			student_assignment_marks=new String[count][RB.length][4];
			u.setBackground(Color.GRAY);
			back.addActionListener(e->{
				teacherlogin n = new teacherlogin();
				dispose();
			});
			lout.addActionListener(e->{
				teacherlogin n = new teacherlogin();
				dispose();
			});
			
			update.addActionListener(e->{
				for(int i=0;i<RB.length;i++) {
					if(RB[i].isSelected()) {
						quiz_index = i;
						assignment_index = i;
						update up = new update();
						dispose();	
					}
				}
			});
		
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	class update extends JFrame{
		public update(){
			File quiz_marks = new File("quiz marks.txt");
			File assignment_marks = new File("assignment marks.txt");
			
			JPanel p1=new JPanel();
			JPanel p2=new JPanel();
			JPanel p3=new JPanel();
			JPanel p4=new JPanel();
			JPanel p5=new JPanel();
			JPanel p6=new JPanel();
			JPanel p7=new JPanel();
			JPanel p8=new JPanel();
			JPanel p9=new JPanel();
			JPanel w=new JPanel();
			JPanel s=new JPanel();
		
			JLabel l = new JLabel("Quiz Marks");
			JLabel l1 = new JLabel("Quiz 1");
			JLabel m1 = new JLabel("/10");
			JLabel l2 = new JLabel("Quiz 2");
			JLabel m2 = new JLabel("/10");
			JLabel l3 = new JLabel("Quiz 3");
			JLabel m3 = new JLabel("/10");
			JLabel l4 = new JLabel("Quiz 4");
			JLabel m4 = new JLabel("/10");
			JTextField[]t=new JTextField[4];
			t[0]=new JTextField(5);
			t[1]=new JTextField(5);
			t[2]=new JTextField(5);
			t[3]=new JTextField(5);
			
			JLabel a = new JLabel("Assignment Marks");
			
			JLabel a1 = new JLabel("Assignment 1");
			JLabel c1 = new JLabel("/10");
			JLabel a2 = new JLabel("Assignment 2");
			JLabel c2 = new JLabel("/10");
			JLabel a3 = new JLabel("Assignment 3");
			JLabel c3 = new JLabel("/10");
			JLabel a4 = new JLabel("Assignment 4");
			JLabel c4 = new JLabel("/10");
			JTextField[]b=new JTextField[4];
			b[0]=new JTextField(5);
			b[1]=new JTextField(5);
			b[2]=new JTextField(5);
			b[3]=new JTextField(5);
			if(quiz_marks.exists()) {
				try {
					Scanner in0=new Scanner(quiz_marks);
					for(int i=0;i<student_quiz_marks.length;i++) {
						for(int j=0;j<student_quiz_marks[i].length;j++) {
							for(int k=0;k<student_quiz_marks[i][j].length;k++) {
								student_quiz_marks[i][j][k]=in0.nextLine();							
								}
							}
						}
					in0.close();
					
				}catch(FileNotFoundException ex) {}
				for(int i=0;i<4;i++) {
					if(!student_quiz_marks[course_index][assignment_index][i].contentEquals("null"))
						t[i].setText(student_quiz_marks[course_index][quiz_index][i]);
				}
			}
			if(assignment_marks.exists()) {
				try {
					Scanner in0=new Scanner(assignment_marks);
					for(int i=0;i<student_assignment_marks.length;i++) {
						for(int j=0;j<student_assignment_marks[i].length;j++) {
							for(int k=0;k<student_assignment_marks[i][j].length;k++) {
								student_assignment_marks[i][j][k]=in0.nextLine();							
								}
							}
						}
					in0.close();
					}catch(FileNotFoundException ex) {}
				for(int i=0;i<4;i++) {
					if(!student_assignment_marks[course_index][assignment_index][i].contentEquals("null"))
						b[i].setText(student_assignment_marks[course_index][assignment_index][i]);
				}
			}
			
			
			JButton update = new JButton("Update");
			
			w.add(l);
			p1.add(l1);
			p1.add(t[0]);
			p1.add(m1);
			p2.add(l2);
			p2.add(t[1]);
			p2.add(m2);
			p3.add(l3);
			p3.add(t[2]);
			p3.add(m3);
			p4.add(l4);
			p4.add(t[3]);
			p4.add(m4);
			s.add(a);
			p5.add(a1);
			p5.add(b[0]);
			p5.add(c1);
			p6.add(a2);
			p6.add(b[1]);
			p6.add(c2);
			p7.add(a3);
			p7.add(b[2]);
			p7.add(c3);
			p8.add(a4);
			p8.add(b[3]);
			p8.add(c4);
			
			p9.add(update);
			
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			add(u);
			
			add(w);
			add(p1);
			add(p2);
			add(p3);
			add(p4);
			add(s);
			add(p5);
			add(p6);
			add(p7);
			add(p8);
			add(p9);
			u.setBackground(Color.GRAY);
			w.setBackground(Color.PINK);
			s.setBackground(Color.ORANGE);
			back.addActionListener(e->{
				teacher n = new teacher();
				dispose();
			});
			lout.addActionListener(e->{
				teacherlogin n = new teacherlogin();
				dispose();
			});
			update.addActionListener(e->{
				for(int i =0;i<4;i++) 
				student_quiz_marks[course_index][quiz_index][i] = t[i].getText();
				for(int i =0;i<4;i++) 
					student_assignment_marks[course_index][assignment_index][i] = b[i].getText();
				try {
					PrintWriter out0 = new PrintWriter(quiz_marks);
					for(String[][]i:student_quiz_marks) {
						for(String[] j:i) {
							for(String k:j) {
								out0.println(k);
							}
						}
					}
					out0.close();
					PrintWriter out1 = new PrintWriter(assignment_marks);
					for(String[][]i:student_assignment_marks) {
						for(String[]j:i) {
							for(String k:j) {
								out1.println(k);
							}
						}
					}
					out1.close();
				}catch(IOException ex) {
				}
			});
			
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setVisible(true);
			setSize(750,700);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	class admin extends JFrame{
		public admin() {
			
			JButton b1= new JButton("Students");
			JButton b2= new JButton("Teacher");
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			p1.add(back);
			p1.add(lout);
			p2.add(b1);
			p2.add(b2);
			add(p1);
			add(p2);
			back.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();
			});
			lout.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();
			});
			b1.addActionListener(e->{
				adminstudent ab = new adminstudent();
				dispose();
			});
			b2.addActionListener(e->{
				adminteacher ab = new adminteacher();
				dispose();
			});
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	class adminstudent extends JFrame{
		public adminstudent() {
			JButton b1=new JButton("  New Record  ");
			JButton b2=new JButton("View and Edit Record");
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			p1.add(back);
			p1.add(lout);
			p2.add(b1);
			p2.add(b2);
			add(p1);
			add(p2);
			back.addActionListener(e->{
				admin n = new admin();
				dispose();
			});
			lout.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();
			});
			b1.addActionListener(e->{
				newstudent n = new newstudent();
				dispose();
			});
			b2.addActionListener(e->{
				editstudent n = new editstudent();
				dispose();
			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	class newstudent extends JFrame{
		public newstudent() {
			
			JLabel l1 = new JLabel("Enter number of students");
			JTextField t1 = new JTextField(70);
			JButton b1 = new JButton("Submit");
			JButton back = new JButton ("Back");
			add(l1);
			add(t1);
			add(back);
			add(b1);
			back.addActionListener(e->{
				adminstudent n = new adminstudent();
				dispose();
			});
			b1.addActionListener(e->{
				String nm = t1.getText();
				int n = Integer.parseInt(nm);
				student_name= new String[n];
				student_reg_no= new String[n];
				student_passwords= new String[n];
				for(int i=0;i<n;i++) {
					int j=i+1;
					JTextField field1=new JTextField();
					JTextField field2=new JTextField();
					JTextField field3=new JTextField();
					Object[] message = {
							"Enter name of Student "+j, field1,
							"Enter registration number of Student "+j, field2,
							"Enter password of Student "+j, field3,
						   };
					int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION){
						student_name[i] = field1.getText();
						student_reg_no[i] = field2.getText();;
						student_passwords[i] = field3.getText();;
					}
					if (option == JOptionPane.CANCEL_OPTION) {
						break;
					   }
				}
				File student_Name = new File("student name.txt");
				File student_registration = new File("student registration number.txt");
				File student_pass = new File("student passwords.txt");
				File student_test = new File("student test.txt");
				try{
					PrintWriter out0 = new PrintWriter(student_Name);
					for(int j = 0; j<student_name.length;j++) {
						out0.println(student_name[j]);
					}
					out0.close();
					PrintWriter out1 = new PrintWriter(student_registration);
					for(int j = 0; j<student_reg_no.length;j++) {
						out1.println(student_reg_no[j]);
					}
					out1.close();
					PrintWriter out2 = new PrintWriter(student_pass);
					for(int j = 0; j<student_passwords.length;j++) {
						out2.println(student_passwords[j]);
					}
					out2.close();
					PrintWriter out3 = new PrintWriter(student_test);
					for(int j = 0; j<student_name.length;j++) {
						out3.println("test"+j);
					}
					out3.close();
										
				}catch(IOException ex) {}
				
			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	class editstudent extends JFrame{
		public editstudent() {
			
			File students = new File("student test.txt");
			File student_Name = new File("student name.txt");
			File student_registration = new File("student registration number.txt");
			File student_pass = new File("student passwords.txt");
			
			try {
				Scanner in = new Scanner(students);
				int count=0;
				while(in.hasNextLine()) {
					String a = in.nextLine();
					count++;
				}
				in.close();
				
				student_name=new String[count];
				student_reg_no=new String[count];
				student_passwords=new String[count];
				
				
				Scanner in0 = new Scanner(student_Name);
				int j=0;
				while(in0.hasNextLine()) {
					student_name[j] =in0.nextLine();
					j++;
				}
				in0.close();
			
				Scanner in1 = new Scanner(student_registration);
				int k=0;
				while(in1.hasNextLine()) {
					student_reg_no[k] =in1.nextLine();
					k++;
				}
				in1.close();
				Scanner in2 = new Scanner(student_pass);
				int l=0;
				while(in2.hasNextLine()) {
					student_passwords[l] =in2.nextLine();
					l++;
				}
				in2.close();
			}catch(FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null,"No record found");
			}
			JLabel[]l1 = new JLabel[student_name.length];
			JLabel[]l2 = new JLabel[student_name.length];
			JLabel[]l3 = new JLabel[student_name.length];
			JTextField[]t1 = new JTextField[student_name.length];
			JTextField[]t2 = new JTextField[student_name.length];
			JTextField[]t3 = new JTextField[student_name.length];
			for(int i=0;i<student_name.length;i++) {
				t1[i] = new JTextField(70);
				t2[i] = new JTextField(70);
				t3[i] = new JTextField(70);
				
			}
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			JPanel panel = new JPanel();
			panel.add(u);
			JPanel[]nl=new JPanel[student_name.length];
			JPanel[]rl=new JPanel[student_name.length];
			JPanel[]pl=new JPanel[student_name.length];
			JPanel[]nt=new JPanel[student_name.length];
			JPanel[]rt=new JPanel[student_name.length];
			JPanel[]pt=new JPanel[student_name.length];
			int j=1;
			for(int i=0;i<student_name.length;i++) {
				nl[i] = new JPanel();
				rl[i] = new JPanel();
				pl[i] = new JPanel();
				nt[i] = new JPanel();
				rt[i] = new JPanel();
				pt[i] = new JPanel();
				l1[i]=new JLabel("Name of Student "+j);
				t1[i].setText(student_name[i]);
				l2[i]=new JLabel("Registration of Student "+j);
				t2[i].setText(student_reg_no[i]);
				l3[i]=new JLabel("passwords of Student "+j);
				t3[i].setText(student_passwords[i]);
				nl[i].add(l1[i]);
				nt[i].add(t1[i]);
				rl[i].add(l2[i]);
				rt[i].add(t2[i]);
				pl[i].add(l3[i]);
				pt[i].add(t3[i]);
				panel.add(nl[i]);
				panel.add(nt[i]);
				panel.add(rl[i]);
				panel.add(rt[i]);
				panel.add(pl[i]);
				panel.add(pt[i]);
				j++;
			}
			JPanel bu = new JPanel();
			JButton b = new JButton("Update");
			bu.add(b);
			panel.add(bu);
			JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
			add(scrollBar);
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			back.addActionListener(e->{
				adminstudent n = new adminstudent();
				dispose();
			});
			lout.addActionListener(e->{
				 adminlogin n = new adminlogin();
				dispose();
			});
			b.addActionListener(e->{
				for(int i=0;i<t1.length;i++) {
					student_name[i] =  t1[i].getText();
					student_reg_no[i] =  t2[i].getText();
					student_passwords[i] =  t3[i].getText();
				}
				try {
					PrintWriter out0 = new PrintWriter(student_Name);
					for(int i=0;i<student_name.length;i++) {
						out0.println(student_name[i]);
					}
					out0.close();
					PrintWriter out1 = new PrintWriter(student_registration);
					for(int i=0;i<student_reg_no.length;i++) {
						out1.println(student_reg_no[i]);
					}
					out1.close();
					PrintWriter out2 = new PrintWriter(student_pass);
					for(int i=0;i<student_passwords.length;i++) {
						out2.println(student_passwords[i]);
					}
					out2.close();
				} catch (FileNotFoundException e1) {}
			});
			
			setVisible(true);
			setSize(800,850);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
																						
		}
	}
	//------------------------------------------------------------------------------------------------------------
	class adminteacher extends JFrame{
		public adminteacher() {
			JButton b1 = new JButton("New Record");
			JButton b2 = new JButton("View and Edit Record");
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			JPanel p1 = new JPanel();
			JPanel p2 = new JPanel();
			p1.add(back);
			p1.add(lout);
			p2.add(b1);
			p2.add(b2);
			add(p1);
			add(p2);
			back.addActionListener(e->{
				admin n = new admin();
				dispose();
			});
			lout.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();
			});

			b1.addActionListener(e->{
				newteacher n = new newteacher();
				dispose();
			});
			b2.addActionListener(e->{
				Editteacher n = new Editteacher();
				dispose();
			});
			setVisible(true);
			setSize(750,700);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	class newteacher extends JFrame{
		public newteacher() {
			JLabel l1 = new JLabel("Enter number of teachers and courses");
			JTextField t1 = new JTextField(70);
			JButton back = new JButton ("Back");
			JButton b1 = new JButton("Submit");
			
			add(l1);
			add(t1);
			add(back);
			add(b1);
			
			back.addActionListener(e->{
				adminteacher n = new adminteacher();
				dispose();
			});
			b1.addActionListener(e->{
				String nm = t1.getText();
				int n = Integer.parseInt(nm);
				teacher_name = new String[n];
				Courses = new String[n];
				teacher_passwords = new String[n];
				for(int i=0;i<n;i++) {
					int j=i+1;
					JTextField field1=new JTextField();
					JTextField field2=new JTextField();
					JTextField field3=new JTextField();
					Object[] message = {
							"Enter name of teacher "+j, field1,
							"Enter Course of teacher "+j, field2,
							"Enter password of teacher "+j, field3,
						   };
					int option = JOptionPane.showConfirmDialog(null, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION){
						teacher_name[i] = field1.getText();
						Courses[i] = field2.getText();
						teacher_passwords[i] = field3.getText();
					}
					if (option == JOptionPane.CANCEL_OPTION) {
						break;
					   }
				}
				File teacher_Name = new File("teacher name.txt");
				File courses = new File("course offered.txt");
				File teacher_pass = new File("teacher passwords.txt");
				File teacher_test = new File("teacher test.txt");
				try{
					PrintWriter out = new PrintWriter(teacher_test);
					for(int j = 0; j<teacher_name.length;j++) {
						out.println("test"+j);
					}
					out.close();
					PrintWriter out0 = new PrintWriter(teacher_Name);
					for(int j = 0; j<teacher_name.length;j++) {
						out0.println(teacher_name[j]);
					}
					out0.close();
					PrintWriter out1 = new PrintWriter(courses);
					for(int j = 0; j<Courses.length;j++) {
						out1.println(Courses[j]);
					}
					out1.close();
					PrintWriter out2 = new PrintWriter(teacher_pass);
					for(int j = 0; j<teacher_passwords.length;j++) {
						out2.println(teacher_passwords[j]);
					}
					out2.close();
					
				}catch(IOException ex) {}

			});
			
			setVisible(true);
			setSize(750,700);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
	}
	class Editteacher extends JFrame{
		public Editteacher() {
			
			File teacher_Name = new File("teacher name.txt");
			File courses = new File("course offered.txt");
			File teacher_pass = new File("teacher passwords.txt");
			File teacher_test = new File("teacher test.txt");
		
			try {
				Scanner in = new Scanner(teacher_test);
				int count=0;
				while(in.hasNextLine()) {
					String a = in.nextLine();
					count++;
				}
				in.close();
				
				teacher_name = new String[count];
				Courses = new String[count];
				teacher_passwords = new String[count];
				
				
				Scanner in0 = new Scanner(teacher_Name);
				int j=0;
				while(in0.hasNextLine()) {
					teacher_name[j] =in0.nextLine();
					j++;
				}
				in0.close();
			
				Scanner in1 = new Scanner(courses);
				int k=0;
				while(in1.hasNextLine()) {
					Courses[k] =in1.nextLine();
					k++;
				}
				in1.close();
				Scanner in2 = new Scanner(teacher_pass);
				int l=0;
				while(in2.hasNextLine()) {
					teacher_passwords[l] =in2.nextLine();
					l++;
				}
				in2.close();
			}catch(FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null,"No record found");
			}
			JLabel[]l1 = new JLabel[teacher_name.length];
			JLabel[]l2 = new JLabel[teacher_name.length];
			JLabel[]l3 = new JLabel[teacher_name.length];
			JTextField[]t1 = new JTextField[teacher_name.length];
			JTextField[]t2 = new JTextField[teacher_name.length];
			JTextField[]t3 = new JTextField[teacher_name.length];
			for(int i=0;i<teacher_name.length;i++) {
				t1[i] = new JTextField(70);
				t2[i] = new JTextField(70);
				t3[i] = new JTextField(70);
				
			}
			int j=1;
			JPanel u = new JPanel();
			JButton back = new JButton ("Back");
			JButton lout = new JButton("Logout"); 
			u.add(back);
			u.add(lout);
			JPanel panel = new JPanel();
			panel.add(u);
			JPanel[]nl=new JPanel[teacher_name.length];
			JPanel[]rl=new JPanel[teacher_name.length];
			JPanel[]pl=new JPanel[teacher_name.length];
			JPanel[]nt=new JPanel[teacher_name.length];
			JPanel[]rt=new JPanel[teacher_name.length];
			JPanel[]pt=new JPanel[teacher_name.length];
			for(int i=0;i<teacher_name.length;i++) {
				nl[i] = new JPanel();
				rl[i] = new JPanel();
				pl[i] = new JPanel();
				nt[i] = new JPanel();
				rt[i] = new JPanel();
				pt[i] = new JPanel();
				l1[i]=new JLabel("Name of teacher "+j);
				t1[i].setText(teacher_name[i]);
				l2[i]=new JLabel("Course "+j);
				t2[i].setText(Courses[i]);
				l3[i]=new JLabel("passwords of teacher "+j);
				t3[i].setText(teacher_passwords[i]);
				nl[i].add(l1[i]);
				nt[i].add(t1[i]);
				rl[i].add(l2[i]);
				rt[i].add(t2[i]);
				pl[i].add(l3[i]);
				pt[i].add(t3[i]);
				panel.add(nl[i]);
				panel.add(nt[i]);
				panel.add(rl[i]);
				panel.add(rt[i]);
				panel.add(pl[i]);
				panel.add(pt[i]);
				j++;
			}
			JPanel bu = new JPanel();
			JButton b = new JButton("Update");
			bu.add(b);
			panel.add(bu);
			JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
			add(scrollBar);
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			back.addActionListener(e->{
				adminteacher n = new adminteacher();
				dispose();
			});
			lout.addActionListener(e->{
				adminlogin n = new adminlogin();
				dispose();	
			});
			b.addActionListener(e->{
				for(int i=0;i<t1.length;i++) {
					teacher_name[i] =  t1[i].getText();
					Courses[i] =  t2[i].getText();
					teacher_passwords[i] =  t3[i].getText();
				}
				try {
					PrintWriter out0 = new PrintWriter(teacher_Name);
					for(int i=0;i<teacher_name.length;i++) {
						out0.println(teacher_name[i]);
					}
					out0.close();
					PrintWriter out1 = new PrintWriter(courses);
					for(int i=0;i<Courses.length;i++) {
						out1.println(Courses[i]);
					}
					out1.close();
					PrintWriter out2 = new PrintWriter(teacher_pass);
					for(int i=0;i<teacher_passwords.length;i++) {
						out2.println(teacher_passwords[i]);
					}
					out2.close();
				} catch (FileNotFoundException e1) {}
			});
			
			setVisible(true);
			setSize(800,850);
			setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		}
	}
	class teachermsg extends JFrame{
		public teachermsg(){
			JTextField t = new JTextField(70);
			JLabel[]l=null;
			File chat1 = new File("techerchat.txt");
			File chat2 = new File("studentchat.txt");
			File chatstdTest = new File("studentchattest.txt");
			File chatteachtest = new File("teacherchattest");
			JButton sub = new JButton("Submit");
			try {
				Scanner in = new Scanner(chatstdTest);
				int count = 0 ;
				while(in.hasNext()) {
					String a = in.nextLine();
					count++;
				}
				in.close();
				chatstudent = new String[count];
				l = new JLabel[count];
				Scanner in0 =  new Scanner(chat2);
				for(int i=0;i<count;i++) {
					chatstudent[i]=in0.nextLine();
				}in0.close();
				for(int i=0;i<count;i++) {
					l[i]=new JLabel(chatstudent[i]);
				}
			}catch(FileNotFoundException e){JOptionPane.showMessageDialog(null,"no notifications");		}
			for(int i=0;i<l.length;i++) {
				add(l[i]);
			}
			add(t);
			add(sub);
			sub.addActionListener(e->{
				String m = t.getText();
				try {
					PrintWriter out4 = new PrintWriter(chat1);
					out4.println(m);
					out4.close();

					PrintWriter out5 = new PrintWriter(chatteachtest);
					out5.println("test");
					out5.close();
				}catch(IOException ex) {
				}
			});
			setVisible(true);
			setSize(800,850);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		}
	}
	class studentmsg extends JFrame{
		public studentmsg(){
			JTextField t = new JTextField(70);
			JLabel[]l=null;
			File chat1 = new File("techerchat.txt");
			File chat2 = new File("studentchat.txt");
			File chatstdTest = new File("studentchattest.txt");
			File chatteachtest = new File("teacherchattest");
			JButton sub = new JButton("Submit");
			try {
				Scanner in = new Scanner(chatteachtest);
				int count = 0 ;
				while(in.hasNext()) {
					String a = in.nextLine();
					count++;
				}
				in.close();
				chatstudent = new String[count];
				l = new JLabel[count];
				Scanner in0 =  new Scanner(chat1);
				for(int i=0;i<count;i++) {
					chatstudent[i]=in0.nextLine();
				}in0.close();
				for(int i=0;i<count;i++) {
					l[i]=new JLabel(chatstudent[i]);
				}
			}catch(FileNotFoundException e){JOptionPane.showMessageDialog(null,"no notifications");		}
			for(int i=0;i<l.length;i++) {
				add(l[i]);
			}
			add(t);
			add(sub);
			sub.addActionListener(e->{
				String m = t.getText();
				try {
					PrintWriter out4 = new PrintWriter(chat2);
					out4.println(m);
					out4.close();

					PrintWriter out5 = new PrintWriter(chatstdTest);
					out5.println("test");
					out5.close();
				}catch(IOException ex) {
				}
			});
			setVisible(true);
			setSize(800,850);
			setLayout(new FlowLayout());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		}
	}
}