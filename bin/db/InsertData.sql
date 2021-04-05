-- USE master
-- DROP DATABASE DBMockFreetuts

-- CREATE DATABASE DBMockFreetuts
USE DBMockFreetuts

SET IDENTITY_INSERT [dbo].[admins] ON 
INSERT admins (id, fullname, [password], username)
VALUES (1, 'Administrator', '$2a$10$ddMpp822Jzi2rl3I61GOZOpn2S4VJXfqGkFyA1YLy/Zve66gmvAR6', 'admin')
SET IDENTITY_INSERT [dbo].[admins] OFF

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
(41, 'Vultr', 38),
(42, 'Website', null),
(43, N'Hosting tốt nhất', 42),
(44, N'VPS tốt nhất', 42),
(45, N'Mua domain ở đâu', 42),
(46, N'Kiến thức domain', 42),
(47, N'Thủ thuật', null ),
(48, N'Điện thoại', 47),
(49, 'Game', 47),
(50, 'Download', null ),
(51, N'Phần mềm', 50),
(52, N'Tài liệu', 50),
(53, N'Font chữ', 50),
(54, N'Môn học', null),
(55, N'Toán', 54),
(56, N'Tiếng Anh', 54),
(57, N'Văn học', 54),
(58, 'Marketing', null),
(59, 'Digital Marketing', 58),
(60, 'Trade Coin', 58),
(61, N'Khám phá', null),
(62, N'Tài chính', 61),
(63, N'Sức khỏe', 61),
(64, N'Ẩm thực', 61),
(65, N'Học HTML căn bản & nâng cao', 7),
(66, N'Học HTML5 căn bản & nâng cao', 7),
(67, N'HTML5 Canvas', 7),
(68, N'Bài tập Java', 5);
SET IDENTITY_INSERT [dbo].[category] OFF
UPDATE category SET thumbnail='learn.png', [description]='Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'

SET IDENTITY_INSERT [dbo].[posts] ON 
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (1, N'huong-dan-download-va-cai-dat-python-tren-window-194.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn các bạn cách tải Python cho Win7 / Win 10, sau khi tải về bạn có thể bắt đầu cài đặt Python trên Win 7 / Win 10 để học series Python này.', N'Hướng dẫn download và cài đặt python trên Window (Win 7 / Win 10)', N'post.jpeg', 36, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (2, N'cai-dat-intellij-idea-hoc-python-3420.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn các bạn cách cài đặt phần mềm Intellij IDEA để học Python, đây là một phần mềm rất hay và được sử dụng để code nhiều ngôn ngữ, trong đó có Python.', N'Cài đặt Intellij IDEA và chạy Hello World trong Python', N'post.jpeg', 13, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (3, N'cach-khai-bao-bien-trong-python-3422.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài học này chúng ta sẽ tìm hiểu cách khai báo biến trong Python, qua bài này bạn sẽ biết cách tạo và sử dụng biến cũng như gán dữ liệu cho biến bằng Python.', N'Cách khai báo biến trong Python', N'post.jpeg', 13, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (4, N'comment-trong-python-195.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn các bạn cách tạo comment trong Python, đây là cách giúp bạn tạo ra những ghi chú trong lúc lập trình với ngôn ngữ Python.', N'Cách tạo comment trong Python', N'post.jpeg', 13, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (5, N'cac-kieu-du-lieu-trong-python-3421.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ giới thiệu các kiểu dữ liệu trong Python, qua bài này bạn sẽ hiểu được cách sử dụng các kiểu dữ liệu thường dùng nhất của Python.', N'Các kiểu dữ liệu trong Python', N'post.jpeg', 13, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (6, N'ep-kieu-du-lieu-trong-python-1702.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn các bạn cách chuyển đổi và ép kiểu trong Python, đây là thao tác thường được sử dụng trong thực tế khi làm việc với Python. Trước khi vào bài mới thì bạn hãy quay lại bài cũ để xem các kiểu dữ liệu trong Python đã nhé, sau đó chúng ta sẽ tiếp tục với phần dưới đây.', N'Cách ép kiểu dữ liệu trong Python', N'post.jpeg', 13, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (7, N'cac-toan-tu-trong-python-3423.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ giới thiệu đến các bạn danh sách các toán tử trong Python, đây là những toán tử được sử dụng rất thường xuyên khi lập trình Python.', N'Các toán tử trong Python', N'post.jpeg', 13, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (8, N'cai-dat-anaconda-3416.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ tìm hiểu khái niệm Anaconda là gì, đồng thời mình cũng hướng dẫn cách cài đặt Anaconda để bắt đầu học Data Science nhé.', N'Anaconda là gì? Cài đặt Anaconda trên Windows - Linux - Mac OS', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (9, N'huong-dan-cai-dat-va-su-dung-jupyter-notebook-3425.html', CAST(N'2021-03-01T00:00:00.0000000' AS DateTime2), N'Nếu bạn là người mới và thắc mắc muốn tìm một công cụ nào giúp phát triển cũng như hỗ trợ tương tác cho project về data science, thì có lẽ hầu hết mọi người sẽ trả lời là Jupyter Notebook.', N'Hướng dẫn cài đặt và sử dụng Jupyter Notebook', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (10, N'cai-dat-package-python-3504.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn các bạn cách cài đặt package Python với pip, đây là lệnh giúp bạn install package, update package trong Python một cách dễ dàng.', N'Hướng dẫn cài đặt package Python với pip', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (11, N'multiprocessing-trong-python-3502.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ tìm hiểu xử lý đa tiến trình trong Python. Đa xử lý hay còn gọi là multiprocessing, thường được dùng để xử lý nhiều tiến trình chạy song song.', N'Multiprocessing trong Python (xử lý đa tiến trình)', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (12, N'xu-ly-mysql-trong-python-3503.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn cách dùng module mysql-connector-python để xử lý kết nối và truy vấn MySQL. Các thao tác trong MySQL cơ bản như kết nối / insert / update / delete và select.', N'Xử lý MySQL trong Python (insert / update / delete / select)', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (13, N'google-translator-trong-python-3507.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài học này chúng ta sẽ tìm hiểu googletrans, hay còn gọi là Python Google Translator, đây là một module dùng để dịch văn bản qua các ngôn ngữ bằng cách sử dụng Google API.', N'Cách sử dụng Google Translator trong Python', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (14, N'json-trong-python-3508.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn cách xử lý chuỗi JSON trong Python, bằng cách sử dụng module json bạn có thể chuyển chuỗi JSON thành dữ liệu có cấu trúc trong Python.', N'Xử lý chuỗi JSON trong Python', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (15, N'random-trong-python-3509.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ hướng dẫn bạn cách tạo số ngẫu nhiên bằng cách sử dụng module random trong Python. Với module này bạn có thể tạo ra một số ngẫu nhiên bất kì dựa với nhiều yêu cầu khác nhau.', N'Random trong Python: Tạo số random ngẫu nhiên', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (16, N'quan-ly-sinh-vien-voi-mysql-va-python-3505.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ làm một bài tập, đó là xây dựng ứng dụng quản lý sinh viên với MySQL và Python cơ bản, qua đó bạn sẽ biết cách xử lý truy vấn CSDL MySQL bằng Python.', N'Ứng dụng quản lý sinh viên với MySQL và Python cơ bản', N'post.jpeg', 14, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (17, N'dictionary-keys.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Phương thức dictionary keys() dùng để lấy danh sách các key và trả về một object chứa tất cả các key trong dictionary đó. Object này sẽ được thể hiện định dạng list.', N'Hàm Dictionary keys() trong Python', N'post.jpeg', 15, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (18, N'dictionary-items.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Phương thức items() dùng để hiển thị danh sách tất cả các phần tử trong dictionary dưới dạng một Tuple, tức là mỗi phần tử sẽ được thể hiện định dạng (key, value).', N'Hàm Dictionary items() trong Python', N'post.jpeg', 15, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (19, N'dictionary-get.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Phương thức get() dùng để lấy một phần tử trong dictionary dựa vào tên key mà ta truyền vào. Get() có hai tham số và ta sẽ lần lượt tìm hiểu ở các phần dưới đây.', N'Hàm Dictionary get() trong Python', N'post.jpeg', 15, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (20, N'dictionary-fromkeys.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Phương thức fromkeys() dùng để tạo ra một dictionary mới dựa vào bộ key được cung cấp bởi người dùng fromkeys() rất hữu ích trong trường hợp bạn muốn tạo ra một dictionary khi đã có danh sách các key và giá trị sẵn.', N'Hàm Dictionary fromkeys() trong Python', N'post.jpeg', 15, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (21, N'dictionary-copy.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ tìm hiểu phương thức dict copy(), phương thức này có công dụng trả về một bản copy nông của dictionary.', N'Hàm Dictionary copy() trong Python', N'post.jpeg', 15, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (22, N'dictionary-clear.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ tìm hiều phương thức Dictionary clear() trong Python, đây là phương thức dùng để xóa tất cả các phần tử ra khỏi Dictionary.', N'Hàm Dictionary clear() trong Python', N'post.jpeg', 15, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (23, N'java-la-gi-gioi-thieu-ngon-ngu-java-1023.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài đầu tiên về series tự học Java cơ bản (Java Core) này, chúng ta sẽ lần lượt tìm hiểu về khái niệm Java là gì, sự hình thành của ngôn ngữ này, vì sao ngôn ngữ này lại được đặt tên là Java? Bên cạnh đó, bài viết này cũng sẽ lần lượt giới thiệu những đặc điểm cơ bản và ứng dụng của ngôn ngữ Java và các Platform cơ bản của ngôn ngữ lập trình Java.', N'Java là gì? Giới thiệu ngôn ngữ Java', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (24, N'huong-dan-cai-dat-cau-hinh-va-thiet-lap-bien-moi-truong-cho-java-1024.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Ở bài trước, chúng ta đã tìm hiểu những khái niệm tổng quan, đặc điểm về ngôn ngữ lập trình Java. Trong bài này, tôi sẽ hướng dẫn chi tiết cách cài đặt và cấu hình môi trường JDK (Java Development Kit) để lập trình Java trên hệ điều hành Windows. Đây là một bài khá quan trọng vì khi chúng ta muốn lập trình với bất kỳ loại ngôn ngữ nào thì trước tiên chúng ta cần phải cài đặt đầy đủ và cấu hình các yếu tố cần thiết mà ngôn ngữ đó yêu cầu.', N'Hướng dẫn cài đặt, cấu hình và thiết lập biến môi trường cho Java', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (25, N'huong-dan-cai-dat-cau-hinh-va-cach-su-dung-eclipse-1026.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Ở những bài trước, chúng ta đã tìm hiểu những khái niệm tổng quan, đặc điểm về ngôn ngữ lập trình Java cũng như cách cài đặt, cấu hình và thiết lập biến môi trường JDK để  tiến hành lập trình với Java. Trong bài này, chúng ta sẽ cùng nhau tìm hiểu về cách cài đặt, cấu hình và sử dụng Eclipse - một công cụ dùng để lập trình Java được rất nhiều lập trình viên sử dụng bởi vì Eclipse có thể chạy được trên nhiều nền tảng hệ điều hành khác nhau như Windows, Linux, Mac OS... cũng như có thể tích hợp được nhiều thư viện khác nhau phục vụ cho việc lập trình web và lập trình với cơ sở dữ liệu... Bây giờ chúng ta bắt đầu nhé!', N'Hướng dẫn cài đặt, cấu hình và cách sử dụng Eclipse', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (26, N'chuong-trinh-java-dau-tien-hello-world-1031.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này, tôi sẽ hướng dẫn các bạn từng bước tạo một project trong Java thông qua chương trình HelloWorld. Đây là một chương trình rất phổ biến và tất cả các ngôn ngữ lập trình khác đều sử dụng trong bước đầu làm quen với ngôn ngữ đó. Chương trình này sẽ hiển thị ra màn hình Console dòng thông báo "Hello World". Trong bài này có sử dụng lệnhSystem.out.println(); để xuất thông báo ra màn hình và trong bài tiếp theo tôi sẽ nói rõ hơn về dòng lệnh này.', N'Chương trình Java đầu tiên - HelloWorld', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (27, N'cu-phap-va-quy-tac-java-co-ban-1028.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này, chúng ta sẽ cùng nhau tìm hiểu về một số cú pháp và quy tắc cơ bản trong Java. Đây là một bài rất quan trong, các bạn cần phải nắm rõ các quy tắc và cú pháp có trong bài viết này để có thể lập trình tốt hơn với ngôn ngữ lập trình Java. ', N'Cú pháp và quy tắc Java cơ bản
', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (28, N'cac-kieu-du-lieu-trong-java-1037.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong các bài trước, tôi đã hướng dẫn các bạn về những vấn đề cơ bản nhất trước khi học lập trình với Java. Kể từ bài này trở đi, chúng ta sẽ bắt đầu bước vào tìm hiểu sâu hơn về những khái niệm cần thiết để có thể lập trình Java và có thể giải quyết được những vấn đề mà các bạn gặp phải.', N'Các kiểu dữ liệu trong Java', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (29, N'bien-va-hang-so-trong-java-1038.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài trước, tôi đã giới thiệu cho các bạn khái niệm về kiểu dữ liệu trong Java và 2 kiểu dữ liệu thường gặp đó là Primitive data (Kiểu dữ liệu cơ sở) và Wrapper class. Trong bài này, chúng ta sẽ đi qua hai khái niệm quan trọng khác đó là khái niệm biến (Variable) và hằng số (Constant) trong Java.', N'Biến và hằng số trong Java', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (30, N'cac-toan-tu-thuong-dung-trong-java-1048.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài ngày hôm nay, tôi sẽ giới thiệu đến các bạn các toán tử cơ bản (Basic Operators) trong Java. Sau đó, tôi sẽ đưa ra một ví dụ tổng hợp những gì chúng ta học từ đầu series tới giờ và có sử dụng các loại toán tử này. Trong phần bài tập, tôi cũng sẽ đưa ra một số dạng bài tập cho các bạn tham khảo.', N'Các toán tử thường dùng trong Java', N'post.jpeg', 10, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (31, N'cong-hai-so-trong-java-2556.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ viết một chương trình cộng hai số trong Java, với bài tập này sẽ giúp bạn hiểu được cách sử dụng toán tử cộng trong Java.', N'Cộng hai số trong Java', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (32, N'kiem-tra-so-chan-hay-so-le-trong-java-2557.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Ở bài này chúng ta sẽ thực hiện kiểm tra một số là số chẵn hay số lẻ bằng Java, bài tập này giúp các bạn nắm rõ hơn về câu lênh if và else.', N'Kiểm tra số chẵn hay số lẻ trong Java
', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (33, N'cong-hai-so-phuc-trong-java-2558.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ viết một chương trình tính tổng của hai số phức trong java, với bài tập này các bạn sẽ nắm rõ hơn về cách tạo hàm và sử dụng hàm trong java.', N'Cộng hai số phức trong java
', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (34, N'nhan-hai-so-trong-java-2559.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ viết một chương trình nhân hai số trong Java, với bài tập này sẽ giúp bạn hiểu được cách sử dụng toán tử nhân trong Java.', N'Nhân hai số trong java', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (35, N'kiem-tra-nam-nhuan-trong-java-2560.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ thực hiện chương trình kiểm tra năm nhuận trong Java, nó sẽ giúp các bạn hiểu rõ hơn về câu lệnh if, else trong java.', N'Kiểm tra năm nhuận trong java', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (36, N'kiem-tra-nguyen-am-va-phu-am-trong-java-2562.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ thực hiện chương trình kiểm tra nguyên âm và phụ âm trong java, đây là các ký tự phát ẩm chuẩn trong tiếng Anh.', N'Kiểm tra nguyên âm và phụ âm trong java', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (37, N'tinh-lai-xuat-kep-trong-java-2563.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ viết một chương trình để tính lãi xuất kép bằng ngôn ngữ Java, đây là công thức được sử dụng nhiều trong ngành kế toán tài chính.', N'Tính lãi xuất kép trong java
', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (38, N'tinh-lai-xuat-trong-java-2564.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ thực hiện một chương trình tính lãi xuất đơn giản trong java, đây là công thức khá đơn giản và được sử dụng nhiều khi vay vốn.', N'Tính lãi xuất trong java
', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (39, N'tim-phan-nguyen-va-phan-du-trong-java-2566.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài tập này chúng ta sẽ thực hiện chương trình tìm phần nguyên và phần dư của một số chia cho số khác bằng ngôn ngữ Java. Bạn sẽ vận dụng toán tử % để chia lấy phần dư và / để chia lấy phần nguyên.', N'Tìm phần nguyên và phần dư trong java', N'post.jpeg', 68, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (40, N'lambda-expressions-trong-java-8-3013.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này chúng ta sẽ tìm hiểu về Lambda Expressions trong Java 8, đây là tính năng được thêm vào kể từ phiên bản Java SE 8 nên rất mới.', N'Lambda Expressions trong Java 8
', N'post.jpeg', 12, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (41, N'method-references-trong-java-8-3014.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Ở bài trước mình đã giới thiệu cách sử dụng lambda expressions rồi, vậy thì bài này ta sẽ bàn về một vấn đề có liên quan mật thiết, đó là phương thức tham chiếu (Method References).', N'Method References (phương thức tham chiếu) trong Java 8', N'post.jpeg', 12, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (42, N'html-la-gi-bo-cuc-html-cua-mot-trang-web-420.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Khi bắt đầu làm quen với lập trình web thì HTML chính là nội dung đầu tiên mà bạn phải học, sau đó bạn sẽ kết hợp với CSS để tạo ra những sản phảm rất là độc đáo. Nghe nói thì hay nhưng bạn mới học nên có lẽ hơi mơ hồ phải không nào :D Ok trong serie này ta  sẽ cùng nhau khám phá nhé.', N'Bài 01: HTML là gì? Bổ cục HTML của một trang web', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (43, N'html-elements-va-attributes-421.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Ở bài HTML là gì mình có nói HTML bản chất giống XML nên nó được tạo thành từ hai thành phần chính đó là tên thẻ (tagname) và các thuộc tính (attribute). Đối với XML thì tên thẻ ta có thể tự định nghĩa nhưng với HTML thì bạn phải sử dụng tên thẻ có trong danh sách HTML Elements, nếu không trình duyệt sẽ không hiểu thẻ mà bạn đang sử dụng là gì.', N'Bài 02: HTML Elements và Attributes', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (44, N'cac-the-html-dinh-dang-van-ban-119.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Kể từ bài này chúng ta bắt đầu tìm hiểu các thẻ HTML thông dụng thường được sử dụng, sau đó chúng ta sẽ áp dụng CSS để xây dựng bổ cục giúp website đẹp hơn. Các thẻ HTML mình trình bày tương đối đơn giản nên bạn có thể sử dụng google để tìm kiếm bất kì một blog lập trình nào.', N'Bài 03: Các thẻ HTML định dạng văn bản', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (45, N'cac-the-html-dinh-dang-heading-va-list-120.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong bài này mình sẽ tìm hiểu hai nhóm thẻ dùng để nhấn mạnh nội dung của một trang web và chia ra từng mục lục giúp cho trang web dễ nhìn hơn. Vấn đề này không những thân thiện với người dùng mà nó còn có tác dụng khá tốt trong việ SEO website.', N'Bài 04: Các thẻ HTML định dạng heading và list', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (46, N'cac-the-html-dinh-dang-table-121.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Table là một định dạng dùng để hiển thị dữ liệu ở dạng danh sách. Mỗi table sẽ được chia ra gồm hai thành phần là cột với hàng, và được tạo thành bởi các thẻ table, tr, td, tbody, thead, tfoot.', N'Bài 05: Các thẻ HTML định dạng Table', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (47, N'dung-the-a-trong-html-de-tao-links-335.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Trong một website luôn tồn tại các link liên kết với nhau. Ví dụ như bài HTML là gì mình đã gán một link tới trang trình bày khái niệm đó. Vậy thì trong bài này chúng ta tìm hiểu cách sử dụng thẻ a để tạo nên những link liên kết như vậy.', N'Bài 06: Dùng thẻ a trong HTML để tạo links', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (48, N'dung-the-img-trong-html-de-tao-hinh-anh-123.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Có câu "một website đẹp phải có hình ảnh, bổ cục rõ ràng và nhiều hiệu ứng bắt mắt". Chỉ với câu nói này thôi đủ để chúng ta liệt kê những công nghệ phải sử dụng để tạo nên nó.', N'Bài 07: Dùng thẻ img trong HTML để tạo hình ảnh', N'post.jpeg', 65, 1)
INSERT [dbo].[posts] ([id], [content_file], [created_date], [description], [name], [thumbnail], [category], [created_by]) VALUES (49, N'su-dung-css-tuy-chinh-giao-dien-html-437.html', CAST(N'2021-01-03T00:00:00.0000000' AS DateTime2), N'Theo mặc định giao diện của các thẻ HTML sẽ không đẹp và không thể nào làm giống như giao diện trong file PSD được, vì vậy ta phải sử dụng thêm CSS để tùy chỉnh hiển thị mặc định của HTML.', N'Bài 08: Sử dụng CSS tùy chỉnh giao diện HTML', N'post.jpeg', 65, 1)
SET IDENTITY_INSERT [dbo].[posts] OFF

SET IDENTITY_INSERT [dbo].[courses] ON 
INSERT [dbo].[courses] ([id], [course_link], [description], [learn_method], [name], [price], [thumbnail], [category], [created_by]) VALUES (1, N'youtube.com', N'aa', N'aa', N'Thiết kế Javascript và illustrator', 179000, 'post.jpeg', 37, 1)
INSERT [dbo].[courses] ([id], [course_link], [description], [learn_method], [name], [price], [thumbnail], [category], [created_by]) VALUES (2, N'youtube.com', N'aa', N'bb', N'Thành thạo học văn phòng (MS Office / Internet / Windows)', 210000, 'post.jpeg', 36, 1)
INSERT [dbo].[courses] ([id], [course_link], [description], [learn_method], [name], [price], [thumbnail], [category], [created_by]) VALUES (3, N'youtube.com', N'aa', N'aa', N'Khóa học test trong thiết kế UI/UX (HP 6.4)', 199000, 'post.jpeg', 37, 1)
SET IDENTITY_INSERT [dbo].[courses] OFF

SET IDENTITY_INSERT [dbo].[comments] ON
INSERT comments (id, comment, commenter_name, commenter_email, [date], post_id, course_id)
VALUES (1, N'Test comment 1', 'Test 1', 'test@gmail.com', CAST(N'2020-08-08 00:00:00.0000000' AS DateTime2), 1, null),
(2, N'Test comment 2', 'Test 2', 'test2@gmail.com', CAST(N'2020-08-08 00:00:00.0000000' AS DateTime2), 1, null),
(3, N'Test comment 3', 'Test 3', 'test3@gmail.com', CAST(N'2020-08-08 00:00:00.0000000' AS DateTime2), null, 1)
SET IDENTITY_INSERT [dbo].[comments] OFF

SET IDENTITY_INSERT [dbo].[discounts] ON 
INSERT discounts (id, available, discount_code, discount_website, discount_percent, provider)
VALUES (1, 1, 'freetuts50', 'https://unica.vn/?aff=2560&src=ft.sidebar.coupon', 50, 'Unica'),
(2, 1, 'TINO30_2020', 'https://tinohost.com/', 30, 'TinoHost'),
(3, 1, 'INET30UP', 'https://inet.vn/?aff=158288', 30, 'INET')
SET IDENTITY_INSERT [dbo].[discounts] OFF

SET IDENTITY_INSERT [dbo].[payment_methods] ON
INSERT [dbo].[payment_methods] ([id], [available], [name]) VALUES (1, 1, N'Thanh toán qua ngân hàng')
INSERT [dbo].[payment_methods] ([id], [available], [name]) VALUES (2, 1, N'Thanh toán qua bưu điện')
INSERT [dbo].[payment_methods] ([id], [available], [name]) VALUES (3, 1, N'Thanh toán qua paypal')
INSERT [dbo].[payment_methods] ([id], [available], [name]) VALUES (4, 1, N'Thanh toán qua ví momo')
SET IDENTITY_INSERT [dbo].[payment_methods] OFF