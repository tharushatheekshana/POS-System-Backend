INSERT INTO category (name) VALUES
('Fried Rice'),
('Fried Noodles'),
('Nasi Goreng'),
('Kottu'),
('Soup'),
('Chicken'),
('Fish'),
('Omelette'),
('Vegetable'),
('Chop Suey'),
('Biryani');

INSERT INTO item (description, name, price, category_id, image) VALUES
('Wok-tossed steamed rice with tender chicken, fluffy eggs, and fresh vegetables. A savory and satisfying classic.', 'Chicken Fried Rice', 850, 1, 'ChickenFriedRice.webp'),
('This is a classic fried rice dish that is packed with flavor from a variety of seafood ingredients. Common ingredients include shrimp, scallops, calamari, and mussels.', 'Seafood Fried Rice', 1050, 1, 'SeafoodFriedRice.jpg'),
('Try this light version of fried rice, ideal for a side or quick lunch. Mix veggies like carrots, peas, and corn. Add broccoli, mushrooms, or bell peppers for extra flavor.', 'Vegetable Fried Rice', 650, 1, 'VegetableFriedRice.webp'),
('Delicious shrimp fried rice: Cook shrimp with eggs, veggies, and rice. Season with soy sauce, fish sauce, and more.', 'Prawns Fried Rice', 950, 1, 'PrawnsFriedRice.jpg'),
('Tasty fish fried rice: Flake cooked fish with eggs, veggies, and rice. Season with soy sauce, fish sauce, and more.', 'Fish Fried Rice', 850, 1, 'FishFriedRice.jpg'),
('This is a popular dish in Chinese cuisine. It is made with stir-fried chicken, eggs, and noodles. The dish is usually seasoned with soy sauce, oyster sauce, and sesame oil.', 'Chicken and Egg Noodles', 900, 2, 'ChickenAndEggNoodles.jpg'),
('Stir-fried prawns, veggies (cabbage, carrots, onions), and noodles in a savory sauce (soy, oyster, fish sauce).', 'Prawns Fried Noodles', 1040, 2, 'PrawnsFriedNoodles.jpg'),
('Shanghai Special Fried Noodles', 'Shanghai Special Fried Noodles', 1170, 2, 'ShanghaiSpecialFriedNoodles.jpg'),
('A classic Indonesian fried rice dish with chicken, shrimp, vegetables, and egg, cooked in a savory sweet kecap manis sauce and topped with a fried egg and fried shallots.', 'Mixed Nasi Goreng', 1150, 3, 'MixedNasiGoreng.webp'),
('Stir-fried rice with seafood, vegetables, and egg.', 'Seafood Nasi Goreng', 1170, 3, 'SeafoodNasiGoreng.jpg'),
('Devil Chicken (Small) - A fiery Sri Lankan dish featuring succulent chicken pieces marinated in a blend of chilies, aromatics, and spices. Served in a smaller portion', 'Devil chicken small', 1300, 7, 'DevilChickenSmall.jpeg'),
('Chicken Kottu is a popular Sri Lankan dish made with shredded roti (flatbread), chopped chicken, vegetables, spices, and eggs. It is a flavorful and filling dish that is often served as a street food or a main course.', 'Chicken Kottu', 880, 4, 'ChickenKottu.jpg'),
('A Sri Lankan staple, kottu is a stir-fried dish made with leftover roti or godumba roti, chopped vegetables, meat, eggs, and spices. This version features a cheesy twist that is sure to please.', 'Cheese and Mixed Kottu', 1680, 4, 'CheeseAndMixedKottu.jpg'),
('A spicy Sri Lankan dish made with shredded roti (flatbread), vegetables, spices, and melted cheese.', 'Cheese Kottu', 1150, 4, 'CheeseKottu.jpg'),
('A Sri Lankan dish made with shredded roti, vegetables, seafood, and melted cheese. A delicious and satisfying meal that is perfect for any time of day.', 'Seafood & Cheese kottu', 1560, 4, 'SeafoodAndCheeseKottu.webp'),
('A Sri Lankan staple, Kottu is a stir-fried dish made with chopped roti (flatbread), vegetables, meat, and egg.', 'Mixed Kottu', 1150, 4, 'MixedKottu.jpg'),
('Clear vegetable soup is a light and flavorful broth simmered with a variety of chopped vegetables.', 'Clear Vegetable Soup', 280, 5, 'ClearVegetableSoup.jpg'),
('Sri Lankan Devilled Chicken is a spicy stir-fry dish made with fried chicken pieces in a sweet, sour, and chili-based sauce.', 'Devilled Chicken', 1300, 6, 'DevilledChicken.jpg'),
('Indulge in juicy fried chicken with a satisfyingly crunchy onion ring crust.', 'Crispy Fried Chicken with Onion Rings', 1300, 6, 'CrispyFriedChickenWithOnionRings.jpg'),
('Chilli Chicken is a popular Indo-Chinese appetizer featuring tender, bite-sized fried chicken pieces tossed in a sweet, spicy, and tangy chili sauce.', 'Chilli Chicken', 1300, 6, 'ChilliChicken.webp'),
('Stir-fried boiled vegetables is a quick and easy dish made with pre-cooked vegetables that are stir-fried with a sauce for additional flavor.', 'Stir Fried Boiled Vegetable', 650, 9, 'StirFriedBoiledVegetable.jpg'),
('A savory egg dish filled with cooked chicken and your favorite fillings, often served for breakfast or brunch.', 'Chicken Omelette', 350, 8, 'ChickenOmelette.jpg'),
('A mixed omelette is a versatile egg dish filled with various chopped vegetables, cheese, or meats.', 'Mixed Omelette', 450, 8, 'MixedOmelette.jpg'),
('Shanghai Special Chop Suey is a stir-fry dish likely containing various meats, vegetables, and a flavorful sauce, specific to a particular restaurant.', 'Shanghai Special Chop Suey', 1400, 10, 'ShanghaiSpecialChopSuey.jpg'),
('Vegetable Chop Suey is a stir-fried dish with colorful vegetables in a savory sauce, often served over rice.', 'Vegetable Chop Suey', 780, 10, 'VegetableChopSuey.webp'),
('Seafood Chop Suey is a stir-fried dish with shrimp, scallops, or other seafood and colorful vegetables in a savory sauce, typically served over rice.', 'Seafood Chop Suey', 1170, 10, 'SeafoodChopSuey.webp'),
('Chicken Biryani is a flavorful South Asian dish made with seasoned rice, tender chicken, and aromatic spices.', 'Chicken Biryani', 720, 11, 'ChickenBiryani.jpg'),
('Mutton biryani is a flavorful rice dish made with tender mutton pieces, fragrant spices, and herbs.', 'Mutton Biryani', 450, 11, 'MuttonBiryani.jpg'),
('Seafood Biryani is a flavorful Indian rice dish made with seafood like fish, shrimp, and clams, aromatic spices, and fluffy basmati rice.', 'Seafood Biryani', 650, 11, 'SeafoodBiryani.jpg'),
('Vegetable Biryani is a flavorful rice dish made with aromatic basmati rice, vegetables, and fragrant spices.', 'Vegetable Biryani', 400, 11, 'VegetableBiryani.jpg');

INSERT INTO stock_category (name)
VALUES
('Vegetables'),
('Meat'),
('Seafood'),
('Grains'),
('Baking'),
('Dairy'),
('Cooking Oil'),
('Bakery'),
('Condiments'),
('Fruits'),
('Herbs and Spices'),
('Canned Goods'),
('Frozen Foods'),
('Snacks'),
('Beverages'),
('Desserts'),
('Deli'),
('Sauces'),
('Gravies'),
('Others');


INSERT INTO stock (description, name, quantity, stock_category_id)
VALUES
('Fresh tomatoes from local farms', 'Tomatoes', '5 kg', 1),
('Boneless, skinless chicken breast', 'Chicken Breast', '1.5 kg', 2),
('White onions, perfect for salads and sauces', 'Onions', '2.5 kg', 1),
('Fresh Atlantic salmon fillet', 'Salmon Fillet', '800 g', 3);