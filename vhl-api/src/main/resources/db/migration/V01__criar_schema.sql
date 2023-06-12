CREATE TABLE [VHI_CERTIDAO]
(
	[ID_CERTIDAO] [BIGINT] IDENTITY(1,1) NOT NULL, UNIQUE ([ID_CERTIDAO]),
	[DS_LOCAL_ARQUIVAMENTO] VARCHAR(45) NOT NULL,
	[DT_VALIDADE] DATE NOT NULL,
	[QTD_FOLHAS_EXCEDENTES] INT NOT NULL,
	[NR_VIA] TINYINT NOT NULL,
PRIMARY KEY ([ID_CERTIDAO])
) 
