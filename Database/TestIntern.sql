USE [TestIntern]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 9/29/2024 9:33:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK__Categori__3214EC07E4D6FF29] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 9/29/2024 9:33:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NOT NULL,
	[Price] [decimal](10, 2) NOT NULL,
	[Description] [nvarchar](255) NOT NULL,
	[Image] [nvarchar](255) NOT NULL,
	[Img1] [nvarchar](255) NOT NULL,
	[Img2] [nvarchar](255) NOT NULL,
	[Img3] [nvarchar](255) NOT NULL,
	[CategoryId] [bigint] NULL,
	[StyleId] [bigint] NULL,
 CONSTRAINT [PK__Products__3214EC0784BB6219] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Styles]    Script Date: 9/29/2024 9:33:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Styles](
	[Id] [bigint] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK__Styles__3214EC07E112CA93] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([Id], [Name]) VALUES (1, N'Home & Decor')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (2, N'Clothing')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (3, N'Outdoor')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (4, N'Accessories')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (5, N'Indoor')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [Price], [Description], [Image], [Img1], [Img2], [Img3], [CategoryId], [StyleId]) VALUES (3, N'Product 1', CAST(1231.00 AS Decimal(10, 2)), N'Product 1', N'ssss', N'ssss', N'ssss', N'ssss', 1, 1)
INSERT [dbo].[Products] ([Id], [Name], [Price], [Description], [Image], [Img1], [Img2], [Img3], [CategoryId], [StyleId]) VALUES (4, N'Product 2', CAST(1231.00 AS Decimal(10, 2)), N'Product 2', N'img.jpg', N'img.jpg', N'img.jpg', N'img.jpg', 2, 2)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
SET IDENTITY_INSERT [dbo].[Styles] ON 

INSERT [dbo].[Styles] ([Id], [Name]) VALUES (1, N'Modern')
INSERT [dbo].[Styles] ([Id], [Name]) VALUES (2, N'Streetwear')
INSERT [dbo].[Styles] ([Id], [Name]) VALUES (3, N'Colorfull')
INSERT [dbo].[Styles] ([Id], [Name]) VALUES (4, N'Patchwork')
INSERT [dbo].[Styles] ([Id], [Name]) VALUES (5, N'Bohemian')
INSERT [dbo].[Styles] ([Id], [Name]) VALUES (6, N'Vingate')
SET IDENTITY_INSERT [dbo].[Styles] OFF
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Category] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Category]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Style] FOREIGN KEY([StyleId])
REFERENCES [dbo].[Styles] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Style]
GO
