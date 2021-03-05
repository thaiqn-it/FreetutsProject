USE DBMockFreetuts

SET IDENTITY_INSERT [dbo].[category] ON
INSERT INTO category (id, name, parent_id)
VALUES (1, N'Lập trình', null), 
(2, 'Programming', 1),          
(3, 'Frontend Web', 1),         
(4, 'Python', 2),                 
(5, 'Java', 2),                    
(6, 'Ruby', 2),                    
(7, 'HTML & CSS', 3),              
(8, 'Boootstrap', 3),              
(9, 'Javascript', 3),             
(10, 'Java Core', 5),               
(11, 'JSP/Servlet', 5),             
(12, 'Spring', 5),              
(13, 'Python Basic', 4),
(14, 'Machine Learning', 4),
(15, 'Python Advanced', 4),
(16, N'Tin học', null),
(17, 'Word', 16),    
(18, 'Excel', 16),
(19, 'Powerpoint', 16),
(20, 'Access', 16), 
(21, 'Photoshop', 16),
(22, 'Web Backend', 1),
(23, 'PHP', 22),
(24, 'Laravel', 22),   
(25, 'NodeJS', 22),                
(26, 'Mobile Dev', 1),              
(27, 'ReactNative', 26),            
(28, 'Android', 26),                
(29, 'iOS', 26),                    
(30, N'Công cụ', 1),                
(31, N'Học Git', 30),               
(32, 'Testing', 30), 
(33, 'DevTool', 30),
(34, N'Khóa học', null), 
(35, N'Khóa học lập trình', 34),
(36, N'Khóa học tin học VP', 34),
(37, N'Khóa học thiết kế', 34),
(38, N'Mã giảm giá', null),
(39, 'Tinohost', 38),
(40, 'Azdigi', 38),
(41, 'Vultr', 38);              
SET IDENTITY_INSERT [dbo].[category] OFF
UPDATE category SET thumbnail='learn.png', [description]='Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'

SET IDENTITY_INSERT [dbo].[courses] ON 
INSERT [dbo].[courses] ([id], [course_link], [description], [learn_method], [name], [price], [thumbnail], [category], [created_by]) VALUES (1, N'youtube.com', N'aa', N'aa', N'Thi?t k? hi?u ?ng v?i Javascript và illustrator', 111, 'post.jpeg', 37, null)
INSERT [dbo].[courses] ([id], [course_link], [description], [learn_method], [name], [price], [thumbnail], [category], [created_by]) VALUES (2, N'youtube.com', N'aa', N'bb', N'Thành th?o tin h?c van phòng (MS Office / Internet / Windows)', 222, 'post.jpeg', 36, null)
INSERT [dbo].[courses] ([id], [course_link], [description], [learn_method], [name], [price], [thumbnail], [category], [created_by]) VALUES (3, N'youtube.com', N'aa', N'aa', N'Khóa h?c k?ch b?n test trong thi?t k? UI/UX (HP 6.4)', 333, 'post.jpeg', 37, null)
SET IDENTITY_INSERT [dbo].[courses] OFF

SET IDENTITY_INSERT [dbo].[posts] ON 
INSERT [dbo].[posts] ([id], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (1, CAST(N'2020-08-08 00:00:00.0000000' AS DateTime2), N'aa', N'H?c nhanh k? thu?t nhi?p ?nh v?i 5 khóa h?c online giá c?c r?', 'post.jpeg', 37, null)
SET IDENTITY_INSERT [dbo].[posts] OFF


