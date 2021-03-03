USE DBMockFreetuts

INSERT INTO category (name, parent_id)
VALUES (N'Lập trình', null),    --id: 1
('Programming', 1),             --id: 2
('Frontend Web', 1),            --id: 3
('Python', 2),                  --id: 4
('Java', 2),                    --id: 5
('Ruby', 2),                    --id: 6
('HTML & CSS', 3),              --id: 7
('Boootstrap', 3),              --id: 8
('Javascript', 3),              --id: 9
('Java Core', 5),               --id: 10
('JSP/Servlet', 5),             --id: 11
('Spring', 5),                  --id: 12
('Python Basic', 4),            --id: 13
('Machine Learning', 4),        --id: 14
('Python Advanced', 4),         --id: 15
(N'Tin học', null),             --id: 16
('Word', 16),                   --id: 17
('Excel', 16),                  --id: 18
('Powerpoint', 16),             --id: 19
('Access', 16),                 --id: 20
('Photoshop', 16),              --id: 21
('Web Backend', 1),             --id: 22
('PHP', 22),                    --id: 23
('Laravel', 22),                --id: 24
('NodeJS', 22),                 --id: 25
('Mobile Dev', 1),              --id: 26
('ReactNative', 26),            --id: 27
('Android', 26),                --id: 28
('iOS', 26),                    --id: 29
(N'Công cụ', 1),                --id: 30
(N'Học Git', 26),               --id: 31
('Testing', 26),                --id: 32
('DevTool', 26),                --id: 33
(N'Khóa học', null),            --id: 34
(N'Khóa học lập trình', 34),    --id: 35
(N'Khóa học tin học VP', 34),   --id: 36
(N'Khóa học thiết kế', 34),     --id: 37
(N'Mã giảm giá', null),         --id: 38
('Tinohost', 38),               --id: 39
('Azdigi', 38),                 --id: 40
('Vultr', 38);                   --id: 41
