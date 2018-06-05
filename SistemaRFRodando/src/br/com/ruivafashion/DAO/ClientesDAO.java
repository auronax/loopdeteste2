package br.com.ruivafashion.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.ruivafashion.domain.Clientes;
import br.com.ruivafashion.factory.ConexaoBd;

public class ClientesDAO {
	public void salvar(Clientes c) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO clientes ");
		sql.append("(nome, ");
		sql.append("cpf, ");
		sql.append("rg, ");
		sql.append("sexo, ");
		sql.append("email, ");
		sql.append("datanascimento, ");
		sql.append("endereco, ");
		sql.append("cep, ");
		sql.append("cidade, ");
		sql.append("bairro, ");
		sql.append("estado, ");
		sql.append("pontoreferencia, ");
		sql.append("telefone, ");
		sql.append("telefone2, ");
		sql.append("senha) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
	
		Connection conexao = ConexaoBd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, c.getNome());
		comando.setString(2, c.getCpf());
		comando.setString(3, c.getRg());
		comando.setString(4, c.getSexo());
		comando.setString(5, c.getEmail());
		comando.setString(6, c.getDatanascimento());
		comando.setString(7, c.getEndereco());
		comando.setString(8, c.getCep());
		comando.setString(9, c.getCidade());
		comando.setString(10, c.getBairro());
		comando.setString(11, c.getEstado());
		comando.setString(12, c.getPontoreferencia());
		comando.setString(13, c.getTelefone());
		comando.setString(14, c.getTelefone2());
		comando.setString(15, c.getSenha());
		comando.execute();

	}

	public void excluir(Clientes c) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM clientes  ");
		sql.append("WHERE idclientes = ? ");

		Connection conexao = ConexaoBd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, c.getIdclientes());
		comando.executeUpdate();

	}

	public void alterar(Clientes c) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("UPDATE clientes  ");
		sql.append("SET nome = ?,cpf = ?,rg = ?,sexo = ?,email = ?,datanascimento = ?,endereco = ?, cep = ?, cidade = ?, bairro = ?, estado = ?, pontoreferencia = ?,telefone = ?, telefone2 =?, senha = ?");
		sql.append("WHERE idclientes = ? ");

		Connection conexao = ConexaoBd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, c.getNome());
		comando.setString(2, c.getCpf());
		comando.setString(3, c.getRg());
		comando.setString(4, c.getSexo());
		comando.setString(5, c.getEmail());
		comando.setString(6, c.getDatanascimento());
		comando.setString(7, c.getEndereco());
		comando.setString(8, c.getCep());
		comando.setString(9, c.getCidade());
		comando.setString(10, c.getBairro());
		comando.setString(11, c.getEstado());
		comando.setString(12, c.getPontoreferencia());
		comando.setString(13, c.getTelefone());
		comando.setString(14, c.getTelefone2());
		comando.setString(15, c.getSenha());
		comando.setInt(16, c.getIdclientes());
		
		comando.execute();
	}

	public Clientes Pesquisar(Clientes c) throws SQLException {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT idclientes,nome,cpf ");
		sql.append("FROM clientes ");
		sql.append("WHERE idclientes = ? ");

		Connection conexao = ConexaoBd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setInt(1, c.getIdclientes());

		ResultSet resultado = comando.executeQuery();
		Clientes retorno = null;

		if (resultado.next()) {
			retorno = new Clientes();
			retorno.setIdclientes(resultado.getInt("idclientes"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setCpf(resultado.getString("cpf"));
		}

		return retorno;

	}

public ArrayList<Clientes> pesquisarPorNome(Clientes c) throws SQLException{
	StringBuilder sql = new StringBuilder();
	sql.append("SELECT idclientes,nome " );
	sql.append("FROM clientes " );
	sql.append("WHERE nome LIKE  ? " );
	sql.append("ORDER BY nome ASC ");
	
	Connection conexao = ConexaoBd.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());
	
	comando.setString(1, "%" + c.getNome() + "%");
	
	ResultSet resultado = comando.executeQuery();
	
	ArrayList<Clientes>lista = new ArrayList<Clientes>();
	
	while(resultado.next()) {
		Clientes item = new Clientes();
		item.setIdclientes(resultado.getInt("idclientes"));
		item.setNome(resultado.getString("nome"));	
		lista.add(item);
	}
	return lista;
		
}

public ArrayList<Clientes> listar() throws SQLException{
	StringBuilder sql = new StringBuilder();

	sql.append("SELECT idclientes,nome,cpf,rg,sexo,email,datanascimento ");
	sql.append("FROM clientes ");
	sql.append("ORDER BY nome ASC ");

	Connection conexao = ConexaoBd.conectar();

	PreparedStatement comando = conexao.prepareStatement(sql.toString());

	ResultSet resultado = comando.executeQuery();
	
	ArrayList<Clientes>lista = new ArrayList<Clientes>();
	
	while(resultado.next()) {
		Clientes c = new Clientes();
		c.setIdclientes(resultado.getInt("idclientes"));
		c.setNome(resultado.getString("nome"));
		c.setCpf(resultado.getString("cpf"));	
		c.setRg(resultado.getString("rg"));
		c.setSexo(resultado.getString("sexo"));
		c.setEmail(resultado.getString("email"));
		c.setDatanascimento(resultado.getString("datanascimento"));
		
		lista.add(c);
	}
	return lista;
}
public static void main(String[] args) {

		
		Clientes c1 = new Clientes();

		c1.setNome("Wellen B Nunes");
		c1.setCpf("038.075.901-29");
		c1.setRg("NT");
		c1.setSexo("M");
		c1.setEmail("NT");
		c1.setDatanascimento("01/05/1993");
		c1.setEndereco("MC 02 lote 68");
		c1.setCep("73252110");
		c1.setCidade("Sobradinho");
		c1.setBairro("Império dos nobres");
		c1.setEstado("DF");
		c1.setPontoreferencia("proximo ao imperio gás");
		c1.setTelefone("99130-2965");
		c1.setTelefone2("99293-6047");
		c1.setSenha("1515");
		
		ClientesDAO cdao = new ClientesDAO();

		try {
			cdao.salvar(c1);
			
			System.out.println("Salvo...");
		} catch (SQLException e) {
			System.out.println("erro...");
			e.printStackTrace();
		}
		  
		/*Clientes c1 = new Clientes();
		
		c1.setIdclientes(5);
		c1.setNome("Davi");
		c1.setCpf("NT");
		c1.setRg("nao");
		c1.setSexo("M");
		c1.setEmail("wellen.borgesnunes19@hotmail.com");
		c1.setDatanascimento("30/07/2012");
		


		

		ClientesDAO cdao = new ClientesDAO();

		try {
			cdao.excluir(c1);
			System.out.println("Deletado...");
		} catch (SQLException e) {
			System.out.println("erro...");
			e.printStackTrace();

		}*/

		/*
	 * Clientes c1 = new Clientes(); c1.setIdclientes(2); c1.setNome("Davi");
	 * 
	 * ClientesDAO cdao = new ClientesDAO();
	 * 
	 * try { cdao.alterar(c1); System.out.println("Alterado..."); } catch
	 * (SQLException e) { System.out.println("erro..."); e.printStackTrace();
	 * 
	 * }
	 */
	/*
	 * Clientes c1 = new Clientes();
	 * 
	 * c1.setIdclientes(2); c1.setNome("Davi");
	 * 
	 * Clientes c2 = new Clientes(); c2.setIdclientes(5);
	 * 
	 * ClientesDAO cdao = new ClientesDAO();
	 * 
	 * try { Clientes f3=cdao.Pesquisar(c1); Clientes f4=cdao.Pesquisar(c2);
	 * System.out.println("Resultado: " + f3); System.out.println("Resultado:" +
	 * f4);} catch (SQLException e) { System.out.println("erro...");
	 * e.printStackTrace(); }
	 */
	
	/*ClientesDAO cdao = new ClientesDAO();

	try
	{
		ArrayList<Clientes> lista = cdao.listar();
		for (Clientes c : lista) {
			System.out.println("Resultado  " + c);
		}
	}catch(
	SQLException e)
	{
		System.out.println("erro...");
		e.printStackTrace();
	}*/

}

public Clientes getEmail(String email, String senha) {
	// TODO Auto-generated method stub
	return null;
}
}
