create table usuarios(
    id bigint not null auto_increment,
    nombre varchar(100) not null,         -- 🔹 nuevo campo
    username varchar(100) not null,
    password varchar(255) not null,
    role varchar(10) not null,
    primary key(id)
);
