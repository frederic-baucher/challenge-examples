create table cat
(
   id   int             NOT NULL AUTO_INCREMENT,
   name VARCHAR(50)     NOT NULL,
   url  VARCHAR(255)    NOT NULL,
   CONSTRAINT pk_cat PRIMARY KEY (id)
);

create table comment
(
   id       int             NOT NULL AUTO_INCREMENT,
   content  VARCHAR (255)   NOT NULL,
   who      VARCHAR (255)   NOT NULL,
   cat_id   INT             NOT NULL,

   CONSTRAINT pk_comment PRIMARY KEY (id),
   CONSTRAINT fk_comemnt_cat FOREIGN KEY (cat_id) REFERENCES cat(id) ON delete CASCADE
);
