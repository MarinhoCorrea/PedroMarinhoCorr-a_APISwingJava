import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class CadastroUsuario {
    public static void main(String[] args) {

        // Criação e  configuração do frame
        JFrame frame = new JFrame("Cadastro de Usuário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        // Criação dos labels e campos de texto
        JLabel nameLabel = new JLabel("Nome:");
        JTextField nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(30);

        JLabel idadeLabel = new JLabel("Idade:");
        JTextField idadeField = new JTextField(2);

        // Criação escolha de gênero
        JRadioButton masculinoButton = new JRadioButton("Masculino");
        JRadioButton femininoButton = new JRadioButton("Feminino");
        ButtonGroup generoGroup = new ButtonGroup();
        generoGroup.add(masculinoButton);
        generoGroup.add(femininoButton);
        // Criação do botão de submissão e limpar
        JButton submitButton = new JButton("Cadastrar");
        JButton clearButton = new JButton("Limpar");

        // Adicionando ação ao botão de submissão
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String nome = nameField.getText();
                String email = emailField.getText();
                String idade = idadeField.getText();

                // Verificação de campos obrigatórios
                if (nome.isEmpty() || email.isEmpty() || idade.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Verificação de email válido
                if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(frame, "Email inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Campo de gênero e verificação de seleção
                String genero = masculinoButton.isSelected() ? "Masculino" : femininoButton.isSelected() ? "Feminino" : "Não especificado";

                // Exibição dos dados do usuário
                JOptionPane.showMessageDialog(frame, "Usuário cadastrado: " + "\nNome: " + nome + "\nEmail: " + email +"\nIdade: "+ idade +"\nGênero: " + genero);
            }
        });
        // Adicionando ação ao botão de limpar
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Limpar os campos de texto e botões de seleção
                nameField.setText("");
                emailField.setText("");
                idadeField.setText("");
                masculinoButton.setSelected(false);
                femininoButton.setSelected(false);
                JOptionPane.showMessageDialog(frame, "Campos limpos!");
            }
        });
        submitButton.setSize(100, 30);
        clearButton.setSize(100, 30);

        // adicionando os componentes ao frame
        frame.setLayout(new FlowLayout());
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(idadeLabel);
        frame.add(idadeField);
        frame.add(new JLabel("Gênero:"));
        frame.add(masculinoButton);
        frame.add(femininoButton);
        frame.add(new JLabel("O que deseja fazer ?:"));
        frame.add(submitButton);
        frame.add(clearButton);
        // Exibição do frame
        frame.setVisible(true);
    }
    
}