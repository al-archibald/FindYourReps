BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');


INSERT INTO reps (name, phone, party, email) VALUES
('Richard Shelby', '202-224-5744', 'Republican', 'senator@shelby.senate.gov'),
  ('Tommy Tuberville', '202-224-4124', 'Republican', 'senator@tuberville.senate.gov'),
  ('Lisa Murkowski', '202-224-6665', 'Republican', 'senator@murkowski.senate.gov'),
  ('Dan Sullivan', '202-224-3004', 'Republican', 'senator@sullivan.senate.gov'),
  ('Kyrsten Sinema', '202-224-4521', 'Democrat', 'senator@sinema.senate.gov'),
  ('Mark Kelly', '202-224-2235', 'Democrat', 'senator@kelly.senate.gov'),
  ('Richard Blumenthal', '202-224-2823', 'Democrat', 'senator@blumenthal.senate.gov'),
  ('Chris Murphy', '202-224-4041', 'Democrat', 'senator@murphy.senate.gov'),
  ('Tom Carper', '202-224-2441', 'Democrat', 'senator@carper.senate.gov'),
  ('Chris Coons', '202-224-5042', 'Democrat', 'senator@coons.senate.gov'),
  ('Marco Rubio', '202-224-3041', 'Republican', 'senator@rubio.senate.gov'),
  ('Rick Scott', '202-224-5274', 'Republican', 'senator@scott.senate.gov'),
  ('David Perdue', '202-224-3521', 'Republican', 'senator@perdue.senate.gov'),
  ('Jon Ossoff', '202-224-3643', 'Democrat', 'senator@ossoff.senate.gov'),
  ('Brian Schatz', '202-224-3934', 'Democrat', 'senator@schatz.senate.gov'),
  ('Mazie Hirono', '202-224-6361', 'Democrat', 'senator@hirono.senate.gov'),
  ('Mike Crapo', '202-224-6142', 'Republican', 'senator@crapo.senate.gov'),
  ('Jim Risch', '202-224-2752', 'Republican', 'senator@risch.senate.gov'),
  ('Tammy Duckworth', '202-224-2854', 'Democrat', 'senator@duckworth.senate.gov'),
  ('Dick Durbin', '202-224-2152', 'Democrat', 'senator@durbin.senate.gov'),
  ('Todd Young', '202-224-5623', 'Republican', 'senator@young.senate.gov'),
  ('Mike Braun', '202-224-4814', 'Republican', 'senator@braun.senate.gov'),
  ('Chuck Schumer', '202-224-6542', 'Democrat', 'senator@schumer.senate.gov'),
  ('Kirsten Gillibrand', '202-224-4451', 'Democrat', 'senator@gillibrand.senate.gov'),
  ('Mitch McConnell', '202-224-2541', 'Republican', 'senator@mcconnell.senate.gov'),
  ('Rand Paul', '202-224-4343', 'Republican', 'senator@paul.senate.gov'),
  ('Dianne Feinstein', '202-224-3841', 'Democrat', 'senator@feinstein.senate.gov'),
  ('Alex Padilla', '202-224-3553', 'Democrat', 'senator@padilla.senate.gov'),
  ('Michael Bennet', '202-224-5852', 'Democrat', 'senator@bennet.senate.gov'),
  ('John Hickenlooper', '202-224-5941', 'Democrat', 'senator@hickenlooper.senate.gov'),
  ('Richard Burr', '202-224-3154', 'Republican', 'senator@burr.senate.gov'),
  ('Thom Tillis', '202-224-6342', 'Republican', 'senator@tillis.senate.gov'),
  ('Jeff Merkley', '202-224-3753', 'Democrat', 'senator@merkley.senate.gov'),
  ('Ron Wyden', '202-224-5244', 'Democrat', 'senator@wyden.senate.gov');

  COMMIT TRANSACTION;
