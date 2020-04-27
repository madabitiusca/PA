create table artists
(
    id      integer       not null,
    name    varchar(100) not null,
    country varchar(100) not null,

    constrains artists_pk primary key (id)
);
/

create table albums
(
    id          integer       not null,
    name        varchar(100) not null,
    artist_id integer       not null,

    constraint albums_pk primary key (id),
    CONSTRAINT fk_artists_artist_id FOREIGN KEY (artist_id) REFERENCES artists (id)
);