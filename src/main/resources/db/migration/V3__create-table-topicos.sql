create table topicos(
        id bigint not null auto_increment,
        titulo varchar(100) not null,
        mensaje varchar(255) not null,
        fecha_de_creacion datetime not null,
        status varchar(20) not null,
        autor varchar(50) not null,
        curso_id bigint not null,

        primary key(id),
        constraint fk_topico_curso_id foreign key(curso_id) references cursos(id)
)