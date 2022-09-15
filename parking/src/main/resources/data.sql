insert into rol (idRol, nombreRol) values (1, "administrador");
insert into rol (idRol, nombreRol) values (2, "cliente");
insert into rol (idRol, nombreRol) values (3, "nn");

insert into usuario (cedula, nombre, apellido, telefono, rol, password) values (751175, 'Tobi', 'Hand', 356746761, 1, 'suspendisse');
insert into usuario (cedula, nombre, apellido, telefono, rol, password) values (563575, 'Bellina', 'Keysel', 398604431, 2, 'pede');
insert into usuario (cedula, nombre, apellido, telefono, rol, password) values (638284, 'Melva', 'Jager', 387204730, 2, 'quam');
insert into usuario (cedula, nombre, apellido, telefono, rol, password) values (805714, 'Cornelius', 'Grasha', 320308638, 2, 'congue');
insert into usuario (cedula, nombre, apellido, telefono, rol, password) values (958737, 'Row', 'Twigley', 394624349, 2, 'lobortis');

insert into vehiculo (placa, tipoVehiculo, usuario) values ('GHU876', 'moto', 751175);
insert into vehiculo (placa, tipoVehiculo, usuario) values ('BCF456', 'motocarro', 563575);
insert into vehiculo (placa, tipoVehiculo, usuario) values ('RTQ345', 'carro', 638284);
insert into vehiculo (placa, tipoVehiculo, usuario) values ('GRE754', 'motocarro', 805714);
insert into vehiculo (placa, tipoVehiculo, usuario) values ('PLK257', 'carro', 958737);

insert into tarifa (idTarifa, precio) values (1, '1270');
insert into tarifa (idTarifa, precio) values (2, '2374');
insert into tarifa (idTarifa, precio) values (3, '1826');

insert into zona (idZona, nombreZona, descripcion, espaciosLibres, tarifa) values (1, 'A', 'para moto', 10, 1);
insert into zona (idZona, nombreZona, descripcion, espaciosLibres, tarifa) values (2, 'C', 'para carro', 20, 2);
insert into zona (idZona, nombreZona, descripcion, espaciosLibres, tarifa) values (3, 'CM', 'para motocarro', 5, 3);