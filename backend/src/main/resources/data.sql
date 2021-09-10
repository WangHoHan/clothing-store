INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'tanks');
INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'basics');
INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'long sleeves');
INSERT INTO category (name, sub_category) VALUES ('pants', 'cargos');
INSERT INTO category (name, sub_category) VALUES ('pants', 'joggers');
INSERT INTO category (name, sub_category) VALUES ('jeans', 'regular');
INSERT INTO category (name, sub_category) VALUES ('jeans', 'skinny');
INSERT INTO category (name, sub_category) VALUES ('hoodies & sweatshirts', 'hoodies');
INSERT INTO category (name, sub_category) VALUES ('jackets', 'bombers');
INSERT INTO category (name, sub_category) VALUES ('jackets', 'denim');

INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'black', '100% cotton', 'L', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'black', '100% cotton', 'L', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'dark blue', '98% cotton 2% elastane', '32', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'light beige', '60% cotton 40% polyester', 'M', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'green', '62% polyamide 38% polyester', 'M', '185', '70');

INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('T-shirt with Print', 'classic black t-shirt with Metallica print', 'men', 35.50, NULL, NOW(), 1);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Cargo Pants', 'skinny fit black cargo pants with two large pockets', 'men', 65.00, NULL, NOW(), 2);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Regular Jeans', 'regular jeans in dark blue color', 'men', 120.00, 0.15, NOW(), 3);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Regular Fit Hoodie', 'light beige hoodie with "Rick and Morty" print on front', 'men', 69.00, NULL, NOW(), 4);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Nylon Bomber Jacket', 'short jacket with collar, zipper at front and open inner pocket', 'men', 99.00, 0.35, NOW(), 5);

INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m4HI5vcP0HJyCvtmXruG-IA1RGvSW3R5PAbh6wvUuiS7boOgQVImm0yrjj6wSzO6rsL8WauKu7XGL6n_iQpWEh3Nr0ezcFnoCXtvaki9pHZV-zFB1Xb9scyuo63EpMpt8kOom-WAgjntzSQZsPBE4E9u-zRt9G4yhRZy6OzkXgzbIJY-McgCAh51AgKeNsFHC?width=768&height=1152&cropmode=none', 't-shirt', 1);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m7GBOeAQhU900kh4J9HW5iyXhMkD3Dr4bOfju3qib_4vkWn_rDWjOMsFdL4zN-iVvzuCG_pxrTNThA6_cvUrI2Zen8Ft8JzLuqx5qGCuZw3hTvBpVqXuDZ9Ni6O-x3BnRsx4VlF3vpmQ3S775LOQa3qlWk260frg6IjQwggNs-Gop8S5VH-WG2qWHR4kjjVLr?width=768&height=1152&cropmode=none', 't-shirt 2', 1);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mDY5bUrjdlUtDTkOd9m1K9QFDS2F9oboEoDf3wumaN8XL6-C2Oxowre79CmT9ZlqlAy7MjIitYhD7Y_cj7Ij5K1_foDEOrPDSx5PKk7fmOS6FXTVdr7_sRTkjO9s_PoUukxF170Q7DpaBMZwoN3EH1g8yeQARNtaHOFu_IDZPRXR5OOWcWb3E4zG-SXzn1v2k?width=768&height=1152&cropmode=none', 't-shirt 3', 1);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mv1n3uCHz0zMeWUcbXyKPZJgfQ3HIFgq3XaH3DQCRuvhuSIP2miKGLM8wdBhv9m93-7aZ8NQdzRYX4icHAQz7Zs2kxzGrzLNFnbAya_6giwJGaLGBoRfrdvoIEpl5fz5Oz-shnMdLfFwvgL79E0w-lyggqRcN87Rpe-QdTk3LKDZ_f2-P-yrfxk5y9CxJuoPu?width=768&height=1152&cropmode=none', 'cargos', 2);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mCCNTsKGR2zwAXnN4tfikGBtqkIQp46M2IcZjRXGnQQy4GqKR5eSfLhSUS3LxdW7KSqLD8Xye_BGvuO4b0Rz4VGbuHkztoSaPSBsF-ov_iuocM1cPjrsVpqxUDY8OpeyNIJ8ortcx9p1S75Ix5Q3a1eBv6Xy2SLUNHaqV-unX6VYhARP8vfxfD04bIOn1M6lp?width=768&height=1152&cropmode=none', 'cargos 2', 2);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mlCn6H720pTmc7BboHoQqDnlnLprEA63YMbYaQkUURwn91YyS118hF0G1M-QL_3l0ch4TnmZ-xAOsPJ--Nz5PhrhQ1hSR3-CwwPZKW2wzPevzltQTgr5kjSwYszoqlucYIeiK0u8Mipi7uiGAsmdFrWW5p2LA9uicnUsk4xm1VO0GKGKMv-YUI9mntjNiv2CX?width=768&height=1152&cropmode=none', 'cargos 3', 2);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mHCnZsPxxOuOHXi67c4PzfEjfJzeXbtrFT_0UnaM1ElhOZ20LSDGXbDoQTSCDPX-iHwxyGInAHStJAC0IBtvcFUGkRtELsrhdFJsguh9A6eNLHUnOaJjHWDRApYyAb1C9q2he0HYi4wRl6IeYmrHZU8h0v4lwPkod4KHVAUX1L1KZ4CNUMCWZRBvxXAPU81pg?width=768&height=1152&cropmode=none', 'jeans', 3);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mbGOAnofjh40kU9jVSCS0BEYJYs8W_fqf1cnBno7KhaG1v1i6_TxMVAONT2Nx10Izsnac7wwSuzByT1pyRulAr6FIgms7NDltL_TFKeQPlaxSLzzR7PiT1BXAagjxb0tCixieV9mRD0Yx3bNMWKtW6tQd-VyXpJYaBOubqOlUgv-Q1gzF4aOG64Tc1X_hL_sl?width=768&height=1152&cropmode=none', 'jeans 2', 3);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m_4mOW39JFCA6U-j7W0wM1Qaeldm9skJdmpZDGCLBdqqUoCLl2pMvfDyciGpnd0b0o1khpQKRsYy0csige7fHssk-TSvdMYaCmMvAnhqVZK0Qn8z8NBqyLkArpVfwCiw2neoa81wmdZc6aDAMsdIyuvNcbELvzUrklQOA-O4ggX7vnPEM4Fy1Njdumcb8S4h1?width=768&height=1152&cropmode=none', 'hoodie', 4);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mAd28Y9CmLniQ-Do8-V4c4Nw2LcyfiMvLdt3EYYzliZXV6sHuW3fu7-W4mt3lVwNp4_nqW9FpNeTH9DaNa5Pirx-y0E1ukWyhwFFc4_AhPAk_jbAxFTIpwca9uDLbbBAqj1xNor6qtCGR10-dhEA5-PPnTWoF7Vks_vcAxFz7LV_om0kY3qFrHYt_okHDhZjw?width=768&height=1152&cropmode=none', 'hoodie 2', 4);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m5aBiD0WXyZlYKI8_U3eG7zT4mVaMNeqdyQ4Bwpjw_B2dXoCui4MbxOfveAKNsBk_q-oWus-lkUbhy26L1IAj_FJlfwHfd2POjsVYaRUdKN6-2TEJ6kEDLHlfPyB4asCTrn0nQS15ZV0TipOTsOYTHaSVqophgxPoTzKaFfVVc_eadhfQzKO6Q84OEmdSWr1H?width=768&height=1152&cropmode=none', 'hoodie 3', 4);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m-cpdogTXQ64ey-gj7DPmipEhzsTyPRuerKy6lMtkS6Mq2eUY0uiBfa6PSGW1xx1NkO05tc7QC-Rx3i2iq3LKYQCnj6NpZzMo1kKO3OSkjsiAQkwOI9mHFlS2IpMEdvnw3CuSu7aYWbg60dGU39KqBCBLSblTJXLe0ZkdOO77gNNQz2K4IR5gAhvQT-Atrj0L?width=768&height=1152&cropmode=none', 'bomber', 5);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mKVsjf-56fAxfDKf-iqFNks6SHo_jXp8okziYCkp3R8HzK6ZP9dMadDLxhGSC7CIl2R1XFpCzpr9AlGpeO36XjsbayXtBvw_4872VBZuXHoCDZW_fhwtH4cxT-tUkHLhgTokxrQsL4G7XukvJj9zbDrPxjsIBJ5I7HncBxXyDSSH9U2rEOJsi4XadYf8YhHac?width=768&height=1152&cropmode=none', 'bomber 2', 5);

INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 20, 'M', 1);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 50, 'L', 1);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 20, 'S', 2);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 10, 'L', 2);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 25, '32', 3);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 40, 'M', 4);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 100, 'XL', 4);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 5, 'S', 5);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 5, 'XXL', 5);

INSERT INTO product_categories (product_id, category_id) VALUES (1, 2);
INSERT INTO product_categories (product_id, category_id) VALUES (2, 4);
INSERT INTO product_categories (product_id, category_id) VALUES (3, 6);
INSERT INTO product_categories (product_id, category_id) VALUES (4, 8);
INSERT INTO product_categories (product_id, category_id) VALUES (5, 9);

/*
INSERT INTO customer (email, password, first_name, last_name, phone_number, account_type) VALUES ('jamessmith@example.com', 'password123', 'James', 'Smith', '987654321', 'ROLE_ADMIN');
INSERT INTO customer (email, password, first_name, last_name, phone_number, account_type) VALUES ('johndoe@example.com', 'password123', 'John', 'Doe', '123456789', 'ROLE_CUSTOMER');

INSERT INTO shipping_info (first_name, last_name, line1, postal_code, city, phone_number, user_id) VALUES ('James', 'Smith', '3734 Cambridge Place', '21784', 'Chicago', '987654321', 1);
INSERT INTO shipping_info (first_name, last_name, line1, line2, postal_code, city, phone_number, user_id) VALUES ('John', 'Doe', '4854 Kessla Way', 'apt 11', '29114', 'Miami', '123456789', 2);
INSERT INTO shipping_info (first_name, last_name, line1, postal_code, city, phone_number, user_id) VALUES ('John', 'Doe', '1073 Ashcraft Court', '92041', 'Orlando', '123456789', 2);

INSERT INTO shipping_info (first_name, last_name, line1, postal_code, phone_number, city) VALUES ('Sarah', 'Williams', '2861 Owen Lane', '44308', '111222333', 'Houston');

INSERT INTO purchase_order (state, tracking, shipping_method, payment_method, total, paid, shipping_id, user_id) VALUES ('in transit', 'RA655750668US', 'express', 'PayPal', 75.59, true, 2, 2);
INSERT INTO purchase_order (state, shipping_method, payment_method, total, paid, shipping_id) VALUES ('accepted', 'standard', 'charges forward', 45.49, false, 4);

INSERT INTO order_content (order_id, product_id, size, quantity) VALUES (1, 2, 'L', 1);
INSERT INTO order_content (order_id, product_id, size, quantity) VALUES (2, 1, 'M', 2);*/
