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


