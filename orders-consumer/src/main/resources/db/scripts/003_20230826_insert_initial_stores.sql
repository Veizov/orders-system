--liquibase formatted sql

--changeset denislav.veizov:003
INSERT INTO orders.store(id, name, description, website, review_url)
values (1, 'IKEA',
        'Swedish multinational conglomerate that designs and sells ready-to-assemble furniture, kitchen appliances, decoration, home accessories, and various other goods and home services.',
        'https://www.ikea.bg', 'https://www.ikea.bg/orders/{orderId}/review');

INSERT INTO orders.store(id, name, description, website, review_url)
values (2, 'METRO',
        'Metro AG is a German multinational company based in Düsseldorf which operates business membership-only cash and carry stores primarily under the Metro brand',
        'https://www.metro.bg', 'https://www.metro.bg/orders/{orderId}/review');

INSERT INTO orders.store(id, name, description, website, review_url)
values (3, 'RESERVED',
        'Reserved is a Polish apparel retailer headquartered in Gdańsk, Pomerania, Poland. It was founded in 1999 and remains the largest company of the LPP group, which has more than 1,700 retail stores located in over 20 countries and also owns such brands as Cropp, House, Mohito, and Sinsay',
        'https://www.reserved.com', 'https://www.reserved.com/orders/{orderId}/review');

INSERT INTO orders.store(id, name, description, website, review_url)
values (4, 'DM',
        'dm-drogerie markt (usually abbreviated as dm) is a chain of retail stores headquartered in Karlsruhe, Germany, offering cosmetics, healthcare items, household products and health food and drinks. The company was founded in 1973, when it opened its first store in Karlsruhe.',
        'https://www.dm-drogeriemarkt.bg', 'https://www.dm-drogeriemarkt.bg/orders/{orderId}/review');

INSERT INTO orders.store(id, name, description, website, review_url)
values (5, 'TECHNOMARKET',
        'Technomarket is a Bulgarian retailer of consumer electronics that operates stores in Bulgaria, Kosovo, Serbia, North Macedonia, Bosnia and Herzegovina, Slovakia, Montenegro and Romania.',
        'https://www.technomarket.bg', 'https://www.technomarket.bg/orders/{orderId}/review');
