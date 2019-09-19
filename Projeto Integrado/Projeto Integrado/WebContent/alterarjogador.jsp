<%@page import="br.uninove.modelo.Jogadores"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Informa��es</title>
<link rel="stylesheet" href="visual.css">
<script>
function formatar(mascara, documento){
  var i = documento.value.length;
  var saida = mascara.substring(0,1);
  var texto = mascara.substring(i)
  
  if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
  }
  
}
</script>
</head>
<body>
	<header>
		<h1>Alterar Informa��es</h1>
	</header>

	<% 
		Jogadores jog = (Jogadores)request.getAttribute("jogadorlocalizado");
	%>
	
	<form class="fundo" method="post" action="alterarjogador.do">

		<fieldset>
			<legend> Informa��es Pessoais: </legend>

			<table>
				<thead>
				</thead>
				<tbody>
					<tr>
						<td>Nome:</td>
						<td><input type="text" name="txtnome"
							placeholder="Digite o nome." required="required" value="<%=jog.getNome()%>"></td>
						<td id="espa�o">Idade:</td>
						<td><input type="text" name="txtidade" maxlength="2"
							placeholder="Digite a idade." required="required" value="<%=jog.getIdade()%>"></td>
						<td id="espa�o">Altura:</td>
						<td><input type="text" name="txttamanho" OnKeyPress="formatar('#.##', this)" maxlength="4"
							placeholder="Digite o tamanho em metros." required="required" value="<%=jog.getTamanho()%>">
					</tr>
					<tr>
						<td>RG:</td>
						<td><input type="text" name="txtrg" OnKeyPress="formatar('##.###.###-#', this)" maxlength="12"
							placeholder="Digite o RG sem pontos" required="required" value="<%=jog.getRg()%>" readonly="readonly"></td>

						<td id="espa�o">Peso (kg):</td>
						<td><input type="text" name="txtpeso" OnKeyPress="formatar('##.##', this)" maxlength="5"
							placeholder="Digite o peso em kilos." required="required" value="<%=jog.getPeso()%>"></td>
					</tr>

				</tbody>
			</table>
		</fieldset>

		<fieldset class="status">
			<legend> Status: </legend>
			<table>
				<thead>
				</thead>
				<tbody>
					<tr>
						<td>Time:</td>
						<td><select name="txttime">
								<option value="<%=jog.getTimes().getNm_time() %>
">Selecione o time</option>
								<option value="barcelona">Barcelona</option>
								<option value="liverpool">Liverpool</option>
								<option value="ajax">Ajax</option>
								<option value="tottenham">Tottenham</option>
								<option value="lyon">Lyon</option>
								<option value="juventos">Juventos</option>
								<option value="real">Real Madrid</option>
								<option value="manchester__unt">Manchester United</option>
								<option value="manchester_city">Manchester City</option>
								<option value="psg">Paris Saint Germain</option>
								<option value="dortmund">Dortmund</option>
								<option value="monaco">Monaco</option>
								<option value="porto">Porto</option>
						</select></td>
						<td id="espa�o">Salario: R$</td>
						<td><input type="text" name="txtsalario" OnKeyPress="formatar('####.##', this)" maxlength="7"
							placeholder="Digite o sal�rio" required="required" value="<%=jog.getTimes().getSalario() %>"></td>
						<td>Tempo de Contrato</td>
						<td><input type="number" min="1" name="tempocontrato" value="0"></td>
					</tr>
					<tr>
						<td>Posi��o:</td>
						<td>
							<input type="checkbox" id="c1" name="txtposicao" value="G"><label for="c1">Gol.</label> 
							<input type="checkbox" id="c2" name="txtposicao" value="L"><label for="c2">Lat.</label> 
							<input type="checkbox" id="c3" name="txtposicao" value="A"><label for="c3">Ata.</label> 
							<input type="checkbox" id="c4" name="txtposicao" value="C"><label for="c4">Cen.</label> 
							<input type="checkbox" id="c5" name="txtposicao" value="Z"><label for="c5">Zag.</label> 
							<input type="checkbox" id="c6" name="txtposicao" value="M"><label for="c6">Mei.</label>
						</td>                                                                      

						<td id="espa�o">Camisa:
						<td>
							<table>

						
								<tr>
									<td><input  type="radio" checked id="r0" name="txtcamisa"  value="0"><label class="box"  for="r0"><img src="Imagens/0.png" alt=""></label>
									<td><input  type="radio" id="r1" name="txtcamisa"  value="1"><label class="box"  for="r1">  <img src="Imagens/1.png" alt=""></label>
									<td><input  type="radio" id="r2" name="txtcamisa"  value="2"><label class="box"  for="r2"><img src="Imagens/2.png" alt=""></label>
									<td><input  type="radio" id="r3" name="txtcamisa"  value="3"><label class="box"  for="r3"><img src="Imagens/3.png" alt=""></label>
									<td><input  type="radio" id="r4" name="txtcamisa"  value="4"><label class="box"  for="r4"><img src="Imagens/4.png" alt=""></label>
									<td><input  type="radio" id="r5" name="txtcamisa"  value="5"><label class="box"  for="r5"><img src="Imagens/5.png" alt=""></label>
									<td><input  type="radio" id="r6" name="txtcamisa"  value="6"><label class="box"  for="r6"><img src="Imagens/6.png" alt=""></label>
									<td><input  type="radio" id="r7" name="txtcamisa"  value="7"><label class="box"  for="r7"><img src="Imagens/7.png" alt=""></label>
									<td><input  type="radio" id="r8" name="txtcamisa"  value="8"><label class="box"  for="r8"><img src="Imagens/8.png" alt=""></label>
						                                    
								<tr />                      
								<tr>                        
									                        
							                                
									<td><input  type="radio" id="r9" name="txtcamisa" value="9">  <label class="box"  for="r9" ><img src="Imagens/9.png" alt=""></label>
									<td><input  type="radio" id="r10" name="txtcamisa" value="10"><label class="box"  for="r10"><img src="Imagens/10.png" alt=""></label>
									<td><input  type="radio" id="r11" name="txtcamisa" value="11"><label class="box"  for="r11"><img src="Imagens/11.png" alt=""></label>
									<td><input  type="radio" id="r12" name="txtcamisa" value="12"><label class="box"  for="r12"><img src="Imagens/12.png" alt=""></label>
									<td><input  type="radio" id="r13" name="txtcamisa" value="13"><label class="box"  for="r13"><img src="Imagens/13.png" alt=""></label>
									<td><input  type="radio" id="r14" name="txtcamisa" value="14"><label class="box"  for="r14"><img src="Imagens/14.png" alt=""></label>
									<td><input  type="radio" id="r15" name="txtcamisa" value="15"><label class="box"  for="r15"><img src="Imagens/15.png" alt=""></label>
									<td><input  type="radio" id="r16" name="txtcamisa" value="16"><label class="box"  for="r16"><img src="Imagens/16.png" alt=""></label>
									<td><input  type="radio" id="r17" name="txtcamisa" value="17"><label class="box"  for="r17"><img src="Imagens/17.png" alt=""></label>
                                                            
								</tr>                       
								                            
								<tr>                        
									<td><input  type="radio" id="r18" name="txtcamisa" value="18"><label class="box" for="r18"><img src="Imagens/18.png" alt=""></label> 
									<td><input  type="radio" id="r19" name="txtcamisa" value="19"><label class="box" for="r19"><img src="Imagens/19.png" alt=""></label> 
									<td><input  type="radio" id="r20" name="txtcamisa" value="20"><label class="box" for="r20"><img src="Imagens/20.png" alt=""></label> 
									<td><input  type="radio" id="r21" name="txtcamisa" value="21"><label class="box" for="r21"><img src="Imagens/21.png" alt=""></label> 
									<td><input  type="radio" id="r22" name="txtcamisa" value="22"><label class="box" for="r22"><img src="Imagens/22.png" alt=""></label> 
									<td><input  type="radio" id="r23" name="txtcamisa" value="23"><label class="box" for="r23"><img src="Imagens/23.png" alt=""></label> 
									<td><input  type="radio" id="r24" name="txtcamisa" value="24"><label class="box" for="r24"><img src="Imagens/24.png" alt=""></label> 
									<td><input  type="radio" id="r25" name="txtcamisa" value="25"><label class="box" for="r25"><img src="Imagens/25.png" alt=""></label> 
									<td><input  type="radio" id="r26" name="txtcamisa" value="26"><label class="box" for="r26"><img src="Imagens/26.png" alt=""></label> 
									                                                                  
								</tr>
							
								
								
							
							</table>
				
					
					<tr>
						
					</tr>
				</tbody>
			</table>
		</fieldset>
		<input id="botao" type="submit" value="Cadastrar">
	</form>
	
	<footer>
		<h6>  Lucas Figueiredo de Almeida RA: 918115158 �</h6>
	</footer>
</body>
</html>