package com.js.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.js.util.DbUtil;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table =null;
	private DbUtil dbUtil=new DbUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
			}
		});
				mnNewMenu_2.add(menuItem_2);
				
				JMenuItem menuItem_3 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
				menuItem_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
						bookManageInterFrm.setVisible(true);
						table.add(bookManageInterFrm);
					}
				});
				mnNewMenu_2.add(menuItem_3);
				
				JMenu mnNewMenu = new JMenu("\u6E05\u7A7A\u56FE\u4E66");
				menuBar.add(mnNewMenu);
				
				JMenuItem mntmNewMenuItem = new JMenuItem("\u6E05\u7A7A\u5168\u90E8\u56FE\u4E66");
				mntmNewMenuItem.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AllBookdeleteActionEvent(e);
						
					}
				});
				mnNewMenu.add(mntmNewMenuItem);
				
				JMenuItem menuItem_4 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
				menuBar.add(menuItem_4);
				menuItem_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result=JOptionPane.showConfirmDialog(null, "是否退出系统");
						if(result==0){
							dispose();
						}
					}
				});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();
		contentPane.add(table, BorderLayout.CENTER);
		
		// 设置JFrame最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private void AllBookdeleteActionEvent(ActionEvent e) {
		int result=JOptionPane.showConfirmDialog(null, "是否删除全部图书?");
		if(result==0) {
			Connection con=null;
			try {
				con=dbUtil.getCon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sql="delete  from t_book ";
			try {
				PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();	
			}

		}
		
	}
}
