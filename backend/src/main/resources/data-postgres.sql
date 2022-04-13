INSERT INTO address_entity(address_id, city, country, latitude, longitude, postal_code, street_name, street_number)
VALUES (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.26102, 19.83456, '21000', 'Bulevar Kralja Petra I', '11'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.24486, 19.84264, '21000', 'Bulevar oslobodjenja', '21'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.25730, 19.82045, '21000', 'Branka Bajica', '9L'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.25727, 19.84420, '21000', 'Trifkovicev trg', '6'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.23627, 19.83645, '21000', 'Bulevar Despota Stefana', '5a'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.25685, 19.84165, '21000', 'Safarikova', '1b'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.25, 19.95, '21000', 'Kralja Aleksandra', '12'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.24, 19.62, '21000', 'Petra Drapsina', '2'),
       (nextval('address_seq_gen'), 'Novi Sad', 'Srbija', 45.25346, 19.84465, '21000', 'Bulevar Mihaila Pupina', '9');

INSERT INTO garage_entity(garage_id, capacity, address_id)
VALUES (nextval('garage_seq_gen'), 20, 1),
       (nextval('garage_seq_gen'), 25, 2),
       (nextval('garage_seq_gen'), 35, 3),
       (nextval('garage_seq_gen'), 15, 4),
       (nextval('garage_seq_gen'), 40, 5);

INSERT INTO vehicle_entity(vehicle_id, description, model, price_per_day, is_rented, garage_id)
VALUES (nextval('vehicle_seq_gen'), 'Electric car', 'Tesla Serie 3', 100, false, 1),
       (nextval('vehicle_seq_gen'), 'Electric car', 'Tesla S Plaid', 150, false, 2),
       (nextval('vehicle_seq_gen'), 'Electric car', 'Audi e tron', 120, false, 3),
       (nextval('vehicle_seq_gen'), 'Electric car', 'BMW iX', 350, false, 4),
       (nextval('vehicle_seq_gen'), 'Electric car', 'Genesis GV60', 250, false, 4);

INSERT INTO vehicle_images(vehicle_id, images)
VALUES (1, 'https://vehicle-images-levi9.s3.amazonaws.com/images/tesla3.jpg'),
       (2, 'https://vehicle-images-levi9.s3.amazonaws.com/images/sPlaid.jpg'),
       (3, 'https://vehicle-images-levi9.s3.amazonaws.com/images/etron.jpg'),
       (4, 'https://vehicle-images-levi9.s3.amazonaws.com/images/ix.jpg'),
       (5, 'https://vehicle-images-levi9.s3.amazonaws.com/images/genesis.jpg');

--INSERT INTO renting_entity(renting_id, duration_in_days, end_day, start_day,total_price, user_id, vehicle_id)
--VALUES (nextval('renting_seq_gen'), 2, '2022-04-01', '2022-03-30', 1500, 1, 1);