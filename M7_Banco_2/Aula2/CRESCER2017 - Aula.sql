/* 
1
*/
DECLARE
    
    vCount number;
    CURSOR Lista_Cidades IS
        SELECT Nome, Uf
        FROM Cidade
        GROUP BY Nome, Uf
        HAVING COUNT (*) > 1;
        
    CURSOR Lista_Clientes (pNomeCidade in Cidade.Nome%type , pUf in Cidade.Uf%type) IS
        SELECT Cli.IdCidade, Cli.Nome
        FROM Cliente Cli
        JOIN Cidade Cid ON Cid.IdCidade = Cli.IdCidade
        WHERE pNomeCidade = Cid.Nome AND pUf = Cid.Uf;

BEGIN
  vCount := 0; 
  FOR Cid IN Lista_Cidades LOOP
    FOR Cli IN Lista_Clientes (Cid.Nome, Cid.Uf) LOOP
     DBMS_OUTPUT.PUT_LINE(Cli.Nome);
     vCount := vCount + 1;
    END LOOP;
  END LOOP;
  DBMS_OUTPUT.PUT_LINE(vCount);
END;

/*
2
*/

DECLARE
  vValorPedido Pedido.ValorPedido%type;  
BEGIN
  SELECT SUM (Quantidade * PrecoUnitario)
  INTO VValorPedido
  FROM PedidioItem
  WHERE IdPedido =: IDPedido;
  
  UPDATE Pedido
  SET ValorPedido = vValorPedido
  WHERE IDPedido =: IDPedido;
END;

--PROCEDURE
CREATE OR REPLACE
PROCEDURE Atualiza_Valor_Pedido (pIDPedido IN INTEGER) AS
  vValorPedido  Pedido.ValorPedido%type;
BEGIN

   Select SUM(Quantidade * PrecoUnitario)
   into   vValorPedido
   From   PedidoItem
   Where  IDPedido = pIDPedido;
   
   Update Pedido
   Set    ValorPedido = vValorPedido
   Where  IDPedido    = pIDPedido;

END;