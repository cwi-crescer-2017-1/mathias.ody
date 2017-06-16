CREATE OR REPLACE PACKAGE BODY Pck_Cidades AS
  PROCEDURE Eliminar_Duplicadas IS
  
      CURSOR Lista_Cidades IS
          SELECT Nome, Uf
          FROM Cidade
          GROUP BY Nome, Uf
          HAVING COUNT (*) > 1;

      CURSOR Pegar_Clientes (pNomeCidade in Cidade.Nome%type , pUf in Cidade.Uf%type) IS
          SELECT Cli.IdCidade, Cli.Nome
          FROM Cliente Cli
          JOIN Cidade Cid ON Cid.IdCidade = Cli.IdCidade
          WHERE pNomeCidade = Cid.Nome AND pUf = Cid.Uf
          GROUP BY Cli.IdCidade, Cli.Nome;

    BEGIN
      FOR Cid IN Lista_Cidades LOOP
          SELECT min(Cli.IdCidade) as MenorId
          INTO menor
          FROM Cid
          GROUP BY Cid.IdCidade;

          UPDATE Cliente
          SET IdCidade = Cli.MenorId
          WHERE IdCidade != Cli.MenorId;

        FOR Cli IN Pegar_Clientes (Cid.Nome, Cid.Uf) LOOP  
         DBMS_OUTPUT.PUT_LINE(Cli.Nome || '---' || Cli.IdCidade);
        END LOOP;

        DELETE Cidade
        WHERE IdCidade != Cid.MenorId;

      END LOOP;
    END;

  END pck_cidades;