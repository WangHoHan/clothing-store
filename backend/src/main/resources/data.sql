INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'tanks');
INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'basics');
INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'long sleeves');
INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'printed t-shirts');
INSERT INTO category (name, sub_category) VALUES ('t-shirts', 'crop tops');
INSERT INTO category (name, sub_category) VALUES ('pants', 'cargos');
INSERT INTO category (name, sub_category) VALUES ('pants', 'joggers');
INSERT INTO category (name, sub_category) VALUES ('jeans', 'regular');
INSERT INTO category (name, sub_category) VALUES ('jeans', 'skinny');
INSERT INTO category (name, sub_category) VALUES ('skirts', 'skater skirts');
INSERT INTO category (name, sub_category) VALUES ('hoodies & sweatshirts', 'hoodies');
INSERT INTO category (name, sub_category) VALUES ('jackets', 'bombers');
INSERT INTO category (name, sub_category) VALUES ('jackets', 'denim');
INSERT INTO category (name, sub_category) VALUES ('jackets', 'puffer jackets');

INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'black', '100% cotton', 'L', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'black', '100% cotton', 'L', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'dark blue', '98% cotton 2% elastane', '32', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'light beige', '60% cotton 40% polyester', 'M', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'green', '62% polyamide 38% polyester', 'M', '185', '70');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'dark green', '100% cotton', 'S', '174', '56');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'light gray', '91% polyamide 9% elastane', 'S', '174', '56');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'blue', '92% cotton 6% polyester 2% elastane', '4', '174', '56');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'black', '98% polyester 2% elastane', '4', '174', '56');
INSERT INTO product_info (collection, color, fabrics, model_size, model_height, model_weight) VALUES ('Fall/Winter 2021', 'black', '100% polyester', 'S', '174', '56');

INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('T-shirt with Print', 'classic black t-shirt with Metallica print', 'men', 35.50, NULL, NOW(), 1);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Cargo Pants', 'skinny fit black cargo pants with two large pockets', 'men', 65.00, NULL, NOW(), 2);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Regular Jeans', 'regular jeans in dark blue color', 'men', 120.00, 0.15, NOW(), 3);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Regular Fit Hoodie', 'light beige hoodie with "Rick and Morty" print on front', 'men', 69.00, NULL, NOW(), 4);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Nylon Bomber Jacket', 'short jacket with collar, zipper at front and open inner pocket', 'men', 99.00, 0.35, NOW(), 5);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Oversized printed t-shirt', 't-shirt in soft cotton jersey with a printed design', 'women', 29.90, 0.1, NOW(), 6);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Seamless crop top', 'crop top in ribbed jersey with square neckline and lower-cut at back', 'women', 23.90, NULL, NOW(), 7);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('High ankle jeans', '5-pocket, ankle-length in washed stretch denim', 'women', 125.00, NULL, NOW(), 8);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Pleated skirt', 'short, flared skirt in woven fabric', 'women', 29.50, 0.15, NOW(), 9);
INSERT INTO product (name, description, gender, price, discount, created_at, product_info_id) VALUES ('Short puffer jacket', 'short padded jacket in woven fabric, stand-up collar, zipper at front', 'women', 120.90, NULL, NOW(), 10);

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
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mlJAPKuxlu7Spr6bn5uPqzqFg5KzrjKYJ9foFEfJqBd5O_a7PAT2Be1lrehtvtQXntjM9G9RuyfjupwUmq_weIwa2MmtD3nzxQLqYDFLK8MZxTtpG_alzdFQloNrsaMfGCKQPo8eZvl9hJt29wd-IXJRyIQjoIqC3XwZIA0EtGH_a7Jj2XN3cGRWpFRZRGlgs?width=768&height=1152&cropmode=none', 't-shirt', 6);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mjMOWPVwCJd5Pl-10XgoDc8d_JilT4HeDHxO1-BVPMdateriohziXA-sxBakafOOe8X9P01BsWVzZKACA6XdpG7YYKSplTFNBpivI45pl3pcllGDpS6JpTKGUZ4fDBC-3DiQE2pHgbyX_uiLUiLnVM63RFxi_tjXF52_yjsaQg0ekuhG5de2CObYejweZlW7D?width=768&height=1152&cropmode=none', 't-shirt 2', 6);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mmCPgRmnvWKwMKgsOJguVMvvAUIKQd8tbUk4nrWL1tE8tSN3UHqlEg2fvlNzQt0XPm6WM-fXxJajLZDZZVs9PbL0YG1f0bkrKnAfvJDJ5NbKFSzrBUcUR1iI_DWt4CBNK32EhdLWEp6b9-fXTl2RbuWhvfDcuujBYEq80aBz13yyrwR0xfaDPcotUe_z91QIk?width=768&height=1152&cropmode=none', 'crop top', 7);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mDGDglLmBR3zGrcTthcUnzd8-JpLjYGr2H1QrFMOffQJZ2OfkPn8flFtp-Wcujc6JoEVgfWAgyO3xxox1E-er7sXjppuEjN2qGV-gmLtVJNPuNx65N7hEwnj80NWenWFK19Q3tiMzVeewaNNtp4ixOytrgU51ZIfr7K13rZygml_NQGDxbNj4bUaAUGOvtMLm?width=768&height=1152&cropmode=none', 'crop top 2', 7);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mCX1AyFj2nkgdIlinfOETAjNeSO2FnQ3lYySNja32OcgVmTFqyqyYH95disBZxiARHN7iTn0w-FUIXh921wj9k4kkzC5vBPGNJV6yfc1qC4UT_SIcc5d9lhXFq1If5NW6RY8xWx5F1dHTunnj1vbZrvBRFVGwrViEI5fpE49lD1LTwa0kvslL6sEpInSHF-us?width=768&height=1152&cropmode=none', 'jeans', 8);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m081E9H8RpL3moY9LnvfhRn7-jh4p--S0bpCfx5b0l0qjLjmuFRqYWGZFm0zHFLP7c2oucxaNJY8uRly1VIxlqJe_n41au9XcMVRB2VkIL19-c6f0ojJjHtin20g2AX19RBK9btK47qc3aOWcoDGwHw1uLgs_TjI_M-VKSQZbDVEv3QvNVPgoqBfNZ17tLZ7u?width=768&height=1152&cropmode=none', 'jeans 2', 8);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mhN7wBpHxZ0UJ_Y3kmreAGdKH4vfpjiTpCybav97aXM-x1HX5u3Z7FSWDTAaBkTlsBIZJO3y_okPjsJFGrQjYFnrS9J10yT0BlRe9YzX32nDNz1DhGa5nT6RvC0RDxJSzO3nOqsT3s4ypmMTj3UZZJUwcFF64_KQDip5eBZQ4wlXakvIGuaPnpgAJxrwx9Hc5?width=768&height=1152&cropmode=none', 'skirt', 9);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mlCNLaaaFsMVrdCKXL0eh01HXi0XXuZWY1q1gpLZDlOSuj77Jv3wk435wN6nSz4MRVPJ0hSooMy66wk3LRbSgKm6vZ20ejPQaA6-op5024LrDreZ_qvmUHXj7gJl4m3iVGEwFqFG_rkpNStAtbo0dq0-n_xmxgTMZLCqsB-aCFM5ISI4zMoNSu91kWmwuEsNV?width=768&height=1152&cropmode=none', 'skirt 2', 9);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mVuk2we8QSr3h1HgSGVZdwdkWF4jh1YePKjBnRrwMXefy4KOk9pCMNUGb_l0ln9H4_1kfsKnUhnlgzVOCvFsEW-RNZONglZZ92cmlBqvUo4GOwvDZ74voZWSGbkin-dbY6WUl19Zb_X8ric2zhKv52up8ReFt3JOlDwGa0QXRGg9XJl5Z4kuYSB31wQwyZJ4Z?width=768&height=1152&cropmode=none', 'puffer', 10);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mKUAI2ypwdyvToOrs4hGZKx4WjND4HnusohuaBG6G7Ne6vyTFlBZgXA9XVY6WGj-My-yfFlQzY6DEHZj2HtmgVBGloahrkb_qSilr-6YkYqXfLLmgKVuh0p103-RAtzYG7KN9DYbOX-_2u7Qz32_UQX7JNZ_m6XDbz6hhtvDSgSsTPGGg1989PQkHreXitY-7?width=768&height=1152&cropmode=none', 'puffer 2', 10);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4mVH74TAmt_-W3DL68EymLiaLtFvRtp96ZQPNdl2kVfik1JpZIGVcd5ucooRSac-xaWbLZpq4QrYOfFHk92G2ctUVQKjJ_OFD4jkQESmuOJlrLCgRaN9Uc7OsPuUK1t9OGgWwzNXKmKjE7cNuXAnLwaw_n_tR3RpNk_PZFLmgzuOWCbIxDc1RTFGInY-AWphe0?width=768&height=1152&cropmode=none', 'puffer 3', 10);
INSERT INTO image (file, name, product_info_id) VALUES ('https://am3pap002files.storage.live.com/y4m_COEJjzjzJByDiran58Bu3hF7FS3najUj_bUf5F1OnEWBOBOJaExdZ23_gUzlREjmbRRltkrseyNISv8iBPzyb5emNx4MQFNKEQFc1QKZTkCW_QjoNKuXxP_ekffW-zZtzQe90GYsageDr54vcJku_Eb-ZDkEffAyNoT6F6BrMqNKPggKo3zNyKi5jZMlT4V?width=768&height=1152&cropmode=none', 'puffer 4', 10);

INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 20, 'M', 1);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 50, 'L', 1);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 20, 'S', 2);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 10, 'L', 2);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 25, '32', 3);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 40, 'M', 4);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 100, 'XL', 4);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 5, 'S', 5);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 5, 'XXL', 5);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 25, 'S', 6);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 45, 'M', 6);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 75, 'S', 7);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 20, '4', 8);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 25, '6', 8);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 10, '4', 9);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 5, '8', 9);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 5, 'XS', 10);
INSERT INTO stock (measurements, quantity, size_tag, product_id) VALUES ('20x20x20', 15, 'S', 10);

INSERT INTO product_categories (product_id, category_id) VALUES (1, 2);
INSERT INTO product_categories (product_id, category_id) VALUES (2, 6);
INSERT INTO product_categories (product_id, category_id) VALUES (3, 8);
INSERT INTO product_categories (product_id, category_id) VALUES (4, 11);
INSERT INTO product_categories (product_id, category_id) VALUES (5, 12);
INSERT INTO product_categories (product_id, category_id) VALUES (6, 4);
INSERT INTO product_categories (product_id, category_id) VALUES (7, 5);
INSERT INTO product_categories (product_id, category_id) VALUES (8, 9);
INSERT INTO product_categories (product_id, category_id) VALUES (9, 10);
INSERT INTO product_categories (product_id, category_id) VALUES (10, 14);

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
