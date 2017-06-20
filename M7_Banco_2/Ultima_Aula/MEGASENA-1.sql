/*
   1 - Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena. 
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema. A auditoria deve monitorar tanto 
as apostas quanto os números de cada aposta.
*/

CREATE TABLE LogAposta_Operacao (  
  IDLogAposta             number not null,
  IdApostaAntigo          number,
  IdApostaNovo            number,
  IdConcursoAntigo        number,
  IdConcursoNovo          number,
  IdCidadeAntigo          number,
  IdCidadeNovo            number,
  DataAntigo              date default sysdate,
  DataNovo                date default sysdate,
  QuantidadeNumerosAntigo number,
  QuantidadeNumerosNovo   number,
  ValorAntigo             number,
  ValorNovo               number,
  BolaoAntigo             number,
  BolaoNovo               number,
  Operacao                char(1),
    CONSTRAINT PK_LogAposta_Operacao 
       PRIMARY KEY (IDLogAposta)
);

CREATE SEQUENCE sqLogAposta_Operacao;

CREATE TABLE LogNumero_Operacao (
  IdLogNumero       integer,
  IdNumeroAntigo    integer,
  IdNumeroNovo      integer,
  IdApostaAntigo    integer,
  IdApostaNovo      integer,
  NumeroAntigo    integer,
  NumeroNovo      integer,
  DataAntigo        date default sysdate,
  DataNovo          date default sysdate,
  Operacao      char(1) not null,
    CONSTRAINT PK_LogNumero_Operacao
       PRIMARY KEY (IdLogNumero)
);

CREATE SEQUENCE sqLogNumero_Operacao;


CREATE OR REPLACE
TRIGGER TR_MONITORAR_APOSTA
    AFTER INSERT OR UPDATE OR Delete ON APOSTA
    FOR EACH ROW
DECLARE
  v_operacao char(1);
BEGIN

  IF INSERTING THEN
     v_operacao := 'I';
  ELSIF UPDATING then
     v_operacao := 'U';       
  Else
     v_operacao := 'D';
  END IF;
  
  INSERT INTO LogAposta_Operacao (IDLogAposta, IdApostaAntigo, IdApostaNovo, IdConcursoAntigo, IdConcursoNovo, IdCidadeAntigo,
                IdCidadeNovo, DataAntigo, DataNovo,QuantidadeNumerosAntigo,QuantidadeNumerosNovo,ValorAntigo, ValorNovo,
                BolaoAntigo, BolaoNovo, Operacao)
                
      VALUES (  sqLogAposta_Operacao.nextval, 
                :old.IdAposta,
                :new.IdAposta,
                :old.IdConcurso,
                :new.IdConcurso,
                :old.IdCidade,
                :new.IdCidade,
                :old.Data_Hora,
                :new.Data_Hora,
                :old.Quantidade_Numeros,
                :new.Quantidade_Numeros,
                :old.Valor,
                :new.Valor,
                :old.Bolao,
                :new.Bolao,
                v_operacao);

END TR_MONITORAR_APOSTA;


CREATE OR REPLACE TRIGGER TR_MONITORAR_NUMERO_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Numero_Aposta
    FOR EACH ROW
DECLARE
  v_operacao char(1);
  v_IDAposta Numero_Aposta.IDAposta%type;
  
BEGIN
  IF INSERTING THEN
     v_operacao := 'I';
  ELSIF UPDATING THEN
     v_operacao := 'U';       
  ELSE
     v_operacao := 'D';
  END IF;
  
  INSERT INTO Log_Numero_Operacao (IDLogNumero_Aposta, IDApostaAntigo,IDApostaNovo, 
               IDNumeroAntigo, IDNumeroNovo, NumeroAntigo, NumeroNovo, Data, Operacao) 
               
  VALUES (sqLogNumero_Operacao.nextVal, 
          :old.IDAposta, 
          :new.IDAposta, 
          :old.IDNumero_Aposta, 
          :new.IDNumero_Aposta, 
          :old.Numero, 
          :new.Numero, 
          SYSDATE, 
          v_operacao);
          
END TR_MONITORAR_NUMERO_APOSTA;