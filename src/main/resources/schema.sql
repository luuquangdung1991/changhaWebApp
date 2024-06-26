CREATE TABLE IF NOT EXISTS Boba (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    weight_in_grams INT NOT NULL,
    current_price_in_Euro DOUBLE PRECISION NOT NULL,
    price_per_unit DOUBLE PRECISION NOT NULL,
    last_update_ts varchar(250),
    last_price_in_euro DOUBLE PRECISION,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS Packaging (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    type_of_packaging varchar(250) NOT NULL,
    number_per_pack INT NOT NULL,
    current_price_in_euro INT NOT NULL,
    last_update_ts varchar(250),
    last_price_in_euro DOUBLE PRECISION,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS RawMaterial (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    type_of_material varchar(250) NOT NULL,
    weight_in_grams INT NOT NULL,
    mass_in_milliliters INT NOT NULL,
    price_per_unit INT NOT NULL,
    current_price_in_euro INT NOT NULL,
    last_update_ts varchar(250),
    last_price_in_euro DOUBLE PRECISION,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS RecipeOfDrinks (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    size varchar(250) NOT NULL,
    type_of_drinks varchar(250) NOT NULL,
    sugar INT,
    fruit_syrup INT,
    powder_milk INT,
    coconut_milk INT,
    matcha INT,
    taro INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS RecipeOfSyrup (
    id INT NOT NULL,
    name varchar(250) NOT NULL,
    sugar_in_grams INT,
    gelling_sugar_in_grams INT,
    jam_in_grams INT,
    canned_fruit_in_grams INT,
    boboq_syrup_in_milliliters INT,
    water_in_milliliters INT,
    total_amount INT,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS RecipeOfSyrup (
    name varchar(250) NOT NULL,
    type_of_product varchar(250),
    cost_per_unit DOUBLE PRECISION,
    unit varchar(250),
    PRIMARY KEY (name)
);