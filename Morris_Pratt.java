import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Morris_Pratt extends JFrame {
	
	File f=null;
	String path=null;
	JOptionPane z=new JOptionPane();
	
	
	private JPanel contentPane;
	private JTextField pattern;
	private JTextField textField_1;
	JScrollPane scrollPane;
	JTextArea textArea_1;
	JTextArea textArea_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Morris_Pratt frame = new Morris_Pratt();
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
	public Morris_Pratt() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setVisible(false);
		textArea.setBounds(73, 375, 405, 16);
		contentPane.add(textArea);
		
		
		JButton btnNewButton = new JButton("Dosya Se\u00E7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//textArea_1.setVisible(true);
				
				JFileChooser fileChooser=new JFileChooser();
				fileChooser.showOpenDialog(fileChooser);
				f=fileChooser.getSelectedFile();
				path=f.getAbsolutePath();
				textField_1.setText(path);
				
				
				  try {
							BufferedReader reader = new BufferedReader(new FileReader(f));
							String line=null;
							while (reader.ready()) {
    						line=reader.readLine();
    						textArea.append(line+"\n");
					  }
							reader.close();
					  } catch (Exception ex) {
						//x.showMessageDialog(Morris_Pratt, "HATA: "+ex);
									}

				
				
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(182, 11, 140, 33);
		contentPane.add(btnNewButton);
		
		pattern = new JTextField();
		pattern.setBounds(182, 341, 173, 23);
		contentPane.add(pattern);
		pattern.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(21, 118, 475, 186);
		contentPane.add(scrollPane_2);
		
		textArea_2 = new JTextArea();
		scrollPane_2.setViewportView(textArea_2);
		
		textArea_2.setLineWrap(true);
		
		JLabel lblNewLabel = new JLabel("Aran\u0131lacak Kelime(Pattern) ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 344, 173, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lbl_zaman = new JLabel();
		lbl_zaman.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_zaman.setBounds(104, 609, 173, 23);
		contentPane.add(lbl_zaman);
		
		JLabel lbl_tane = new JLabel();
		lbl_tane.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_tane.setBounds(104, 643, 173, 23);
		contentPane.add(lbl_tane);
		
		JLabel lbl_karsilastirma = new JLabel();
		lbl_karsilastirma.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_karsilastirma.setBounds(104, 677, 232, 23);
		contentPane.add(lbl_karsilastirma);
		
		JButton btnTemizle = new JButton("Temizle");
		btnTemizle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea_1.setText("");
				textArea_2.setText("");
				lbl_karsilastirma.setText("");
				lbl_tane.setText("");
				lbl_zaman.setText("");
				pattern.setText("");
				
				
			}
		});
		btnTemizle.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTemizle.setBounds(435, 340, 78, 24);
		contentPane.add(btnTemizle);
		
		
		
		JButton btnNewButton_1 = new JButton("Ara");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				if(pattern.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Lütfen Patterni Boþ Býrakmayýnýz!");
					
				}
				
				else 
				{  	
					if(textArea_2.getText().equals(""))
					{
						if(textArea_1.getText().equals(""))
						{
							long startTime = System.currentTimeMillis();
							textArea_1.append(MP.findAll(pattern.getText(),textArea.getText()).toString());
							long endTime = System.currentTimeMillis();
							
							int result = (int) (endTime-startTime);
							String cikti=Integer.toString(result);
							lbl_zaman.setText(cikti+" ms(milisaniye)");
							
							int tane=MP.findAll(pattern.getText(),textArea.getText()).size();
							String tane_string=Integer.toString(tane);
							lbl_tane.setText(tane_string+" tane bulundu");
							
							String  mp_karsilastirma=Integer.toString(MP.karsilastirma);
							
							lbl_karsilastirma.setText(mp_karsilastirma+" Karþýlaþtýrma yapýldý");
							System.out.println(mp_karsilastirma+" karsilastirma yapýldý");
							
						
						
						}
						else 
						{
							
							textArea_1.setText("");
							
							long startTime = System.currentTimeMillis();
							textArea_1.append(MP.findAll(pattern.getText(),textArea.getText()).toString());
							long endTime = System.currentTimeMillis();
							
							int result = (int) (endTime-startTime);
							String cikti=Integer.toString(result);
							lbl_zaman.setText(cikti+" ms(milisaniye)");
							
							int tane=MP.findAll(pattern.getText(),textArea.getText()).size();
							String tane_string=Integer.toString(tane);
							lbl_tane.setText(tane_string+" tane bulundu");
							
							String  mp_karsilastirma=Integer.toString(MP.karsilastirma);
							
							lbl_karsilastirma.setText(mp_karsilastirma+" Karþýlaþtýrma yapýldý");
							System.out.println(mp_karsilastirma+" karsilastirma yapýldý");
							
							
							
						}
						
						
						
					}
					else
					{
						if(textArea_1.getText().equals(""))
						{
							long startTime = System.currentTimeMillis();
							textArea_1.append(MP.findAll(pattern.getText(),textArea_2.getText()).toString());
							long endTime = System.currentTimeMillis();
							
							
							int result_1 = (int) (endTime-startTime);
							String cikti=Integer.toString(result_1);
							lbl_zaman.setText(cikti+" ms(milisaniye)");
							
							int tane_1=MP.findAll(pattern.getText(),textArea_2.getText()).size();
							String tane_string=Integer.toString(tane_1);
							lbl_tane.setText(tane_string+" tane bulundu");
							
							String  mp_karsilastirma=Integer.toString(MP.karsilastirma);
							
							lbl_karsilastirma.setText(mp_karsilastirma+" Karþýlaþtýrma yapýldý");
							System.out.println(mp_karsilastirma+" karsilastirma yapýldý");
						}
						
						else
						{
							
							textArea_1.setText("");
							long startTime = System.currentTimeMillis();
							textArea_1.append(MP.findAll(pattern.getText(),textArea_2.getText()).toString());
							long endTime = System.currentTimeMillis();
							
							
							int result_1 = (int) (endTime-startTime);
							String cikti=Integer.toString(result_1);
							lbl_zaman.setText(cikti+" ms(milisaniye)");
							
							int tane_1=MP.findAll(pattern.getText(),textArea_2.getText()).size();
							String tane_string=Integer.toString(tane_1);
							lbl_tane.setText(tane_string+" tane bulundu");
							
							String  mp_karsilastirma=Integer.toString(MP.karsilastirma);
							
							lbl_karsilastirma.setText(mp_karsilastirma+" Karþýlaþtýrma yapýldý");
							System.out.println(mp_karsilastirma+" karsilastirma yapýldý");
							
						}
						
						
						
						
						
					}
					
				
				}
				
				
				
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(365, 340, 60, 24);
		contentPane.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 69, 381, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDosyaYolu = new JLabel("Dosya Yolu");
		lblDosyaYolu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDosyaYolu.setBounds(21, 69, 95, 21);
		contentPane.add(lblDosyaYolu);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 393, 484, 154);
		contentPane.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		scrollPane_1.setViewportView(textArea_1);
		
		textArea_1.setEditable(false);
		textArea_1.setLineWrap(true);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
