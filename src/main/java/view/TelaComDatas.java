package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.awt.event.ActionEvent;

public class TelaComDatas {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComDatas window = new TelaComDatas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaComDatas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(10, 64, 40, 20);
		frame.getContentPane().add(lblData);
		
		final DateTimePicker dataTeste = new DateTimePicker();
		dataTeste.setBounds(80, 60, 300, 30);
		frame.getContentPane().add(dataTeste);
		
		JButton btnPegarData = new JButton("Criar data (java.util.Date)");
		btnPegarData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Atributos próprios do componente datePicker (date e time)
				LocalDate dataSelecionada = dataTeste.getDatePicker().getDate();
				LocalTime horaSelecionada = dataTeste.getTimePicker().getTime();
				
				JOptionPane.showMessageDialog(null, "Data selecionada: " + dataSelecionada.toString());
				JOptionPane.showMessageDialog(null, "Horário selecionado: " + horaSelecionada.toString());
				
				//Preenche uma data utilizando os dois campos do componente
				Date dataCompleta = new Date(dataSelecionada.getYear(), 
						dataSelecionada.getMonthValue(),
						dataSelecionada.getDayOfMonth(),
						horaSelecionada.getHour(),
						horaSelecionada.getMinute(),
						horaSelecionada.getSecond());
			}
		});
		btnPegarData.setBounds(138, 134, 181, 23);
		frame.getContentPane().add(btnPegarData);
	}
}
