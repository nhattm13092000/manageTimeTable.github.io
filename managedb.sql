create database [ManageTimeTable]
Go
USE [ManageTimeTable]
GO

/****** Object:  Table [dbo].[Class]    Script Date: 5/24/2021 11:10:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[ClassID] [int] IDENTITY(1,1) NOT NULL,
	[ClassName] [varchar](50) NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[ClassID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RoomID] [int] IDENTITY(1,1) NOT NULL,
	[RoomName] [varchar](50) NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[RoomID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slot](
	[SlotID] [int] IDENTITY(1,1) NOT NULL,
	[SlotName] [varchar](50) NULL,
	[TimeFrom] [time](7) NULL,
	[TimeTo] [time](7) NULL,
 CONSTRAINT [PK_Slot] PRIMARY KEY CLUSTERED 
(
	[SlotID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher](
	[TeacherID] [int] IDENTITY(1,1) NOT NULL,
	[TeacherName] [varchar](250) NULL,
	[TeacherCode] [varchar](50) NULL,
 CONSTRAINT [PK_Teacher] PRIMARY KEY CLUSTERED 
(
	[TeacherID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TimeTable](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Date] [date] NULL,
	[SlotID] [int] NULL,
	[ClassID] [int] NULL,
	[TeacherID] [int] NULL,
	[RoomID] [int] NULL,
 CONSTRAINT [PK_TimeTable] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Class] ON 
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (1, N'SE1437')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (2, N'SE1434')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (3, N'SE1435')
GO
INSERT [dbo].[Class] ([ClassID], [ClassName]) VALUES (4, N'SE1436')
GO
SET IDENTITY_INSERT [dbo].[Class] OFF
GO
SET IDENTITY_INSERT [dbo].[Room] ON 
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (1, N'321')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (2, N'408')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (3, N'320')
GO
INSERT [dbo].[Room] ([RoomID], [RoomName]) VALUES (4, N'317')
GO
SET IDENTITY_INSERT [dbo].[Room] OFF
GO
SET IDENTITY_INSERT [dbo].[Slot] ON 
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (1, N'Slot 1', CAST(N'07:30:00' AS Time), CAST(N'08:15:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (2, N'Slot 2', CAST(N'08:20:00' AS Time), CAST(N'09:05:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (3, N'Slot 3', CAST(N'09:15:00' AS Time), CAST(N'10:00:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (4, N'Slot 4', CAST(N'10:05:00' AS Time), CAST(N'10:50:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (5, N'Slot 5', CAST(N'13:25:00' AS Time), CAST(N'14:10:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (6, N'Slot 6', CAST(N'14:15:00' AS Time), CAST(N'15:00:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (7, N'Slot 7', CAST(N'15:10:00' AS Time), CAST(N'15:55:00' AS Time))
GO
INSERT [dbo].[Slot] ([SlotID], [SlotName], [TimeFrom], [TimeTo]) VALUES (8, N'Slot 8', CAST(N'16:00:00' AS Time), CAST(N'16:45:00' AS Time))
GO
SET IDENTITY_INSERT [dbo].[Slot] OFF
GO
SET IDENTITY_INSERT [dbo].[Teacher] ON 
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName], [TeacherCode]) VALUES (1, N'Trinh Minh Nhat', N'NhatTM')
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName], [TeacherCode]) VALUES (2, N'Vuong Minh Tuan', N'TuanVM')
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName], [TeacherCode]) VALUES (3, N'Le The Hai', N'HaiLT')
GO
INSERT [dbo].[Teacher] ([TeacherID], [TeacherName], [TeacherCode]) VALUES (4, N'Nguyen Tat Trung', N'TrungNT')
GO
SET IDENTITY_INSERT [dbo].[Teacher] OFF
GO
SET IDENTITY_INSERT [dbo].[TimeTable] ON 
GO
INSERT [dbo].[TimeTable] ([ID], [Date], [SlotID], [ClassID], [TeacherID], [RoomID]) VALUES (1, CAST(N'2021-06-06' AS Date), 1, 1, 1, 1)
GO
INSERT [dbo].[TimeTable] ([ID], [Date], [SlotID], [ClassID], [TeacherID], [RoomID]) VALUES (2, CAST(N'2021-06-07' AS Date), 2, 2, 2, 2)
GO
INSERT [dbo].[TimeTable] ([ID], [Date], [SlotID], [ClassID], [TeacherID], [RoomID]) VALUES (3, CAST(N'2021-06-08' AS Date), 3, 3, 3, 3)
GO
INSERT [dbo].[TimeTable] ([ID], [Date], [SlotID], [ClassID], [TeacherID], [RoomID]) VALUES (4, CAST(N'2021-06-05' AS Date), 4, 4, 4, 4)
GO
INSERT [dbo].[TimeTable] ([ID], [Date], [SlotID], [ClassID], [TeacherID], [RoomID]) VALUES (10, CAST(N'2021-06-05' AS Date), 1, 1, 1, 1)
GO
SET IDENTITY_INSERT [dbo].[TimeTable] OFF
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK_TimeTable_Class] FOREIGN KEY([ClassID])
REFERENCES [dbo].[Class] ([ClassID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK_TimeTable_Class]
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK_TimeTable_Room] FOREIGN KEY([RoomID])
REFERENCES [dbo].[Room] ([RoomID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK_TimeTable_Room]
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK_TimeTable_Slot] FOREIGN KEY([SlotID])
REFERENCES [dbo].[Slot] ([SlotID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK_TimeTable_Slot]
GO
ALTER TABLE [dbo].[TimeTable]  WITH CHECK ADD  CONSTRAINT [FK_TimeTable_Teacher] FOREIGN KEY([TeacherID])
REFERENCES [dbo].[Teacher] ([TeacherID])
GO
ALTER TABLE [dbo].[TimeTable] CHECK CONSTRAINT [FK_TimeTable_Teacher]
GO
USE [master]
GO
ALTER DATABASE [ManageTimeTable] SET  READ_WRITE 
GO

