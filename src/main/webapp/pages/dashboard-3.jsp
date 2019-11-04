
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="" />
	
	<title>Xenon - Dashboard 3</title>

	
	<link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/xenon-core.css">
	<link rel="stylesheet" href="assets/css/xenon-forms.css">
	<link rel="stylesheet" href="assets/css/xenon-components.css">
	<link rel="stylesheet" href="assets/css/xenon-skins.css">
	<link rel="stylesheet" href="assets/css/custom.css">

	<script src="pages/assets/js/jquery-1.11.1.min.js"></script>

	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
		<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
</head>
<body class="page-body">

	<div class="settings-pane">
			
		<a href="#" data-toggle="settings-pane" data-animate="true">
			&times;
		</a>
		
		<div class="settings-pane-inner">
			
			<div class="row">
				
				<div class="col-md-4">
					
					<div class="user-info">
						
						<div class="user-image">
							<a href="extra-profile.jsp">
								<img src="pages/assets/images/user-2.png" class="img-responsive img-circle" />
							</a>
						</div>
						
						<div class="user-details">
							
							<h3>
								<a href="extra-profile.jsp">John Smith</a>
								
								<!-- Available statuses: is-online, is-idle, is-busy and is-offline -->
								<span class="user-status is-online"></span>
							</h3>
							
							<p class="user-title">Web Developer</p>
							
							<div class="user-links">
								<a href="extra-profile.jsp" class="btn btn-primary">Edit Profile</a>
								<a href="extra-profile.jsp" class="btn btn-success">Upgrade</a>
							</div>
							
						</div>
						
					</div>
					
				</div>
				
				<div class="col-md-8 link-blocks-env">
					
					<div class="links-block left-sep">
						<h4>
							<span>Notifications</span>
						</h4>
						
						<ul class="list-unstyled">
							<li>
								<input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk1" />
								<label for="sp-chk1">Messages</label>
							</li>
							<li>
								<input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk2" />
								<label for="sp-chk2">Events</label>
							</li>
							<li>
								<input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk3" />
								<label for="sp-chk3">Updates</label>
							</li>
							<li>
								<input type="checkbox" class="cbr cbr-primary" checked="checked" id="sp-chk4" />
								<label for="sp-chk4">Server Uptime</label>
							</li>
						</ul>
					</div>
					
					<div class="links-block left-sep">
						<h4>
							<a href="#">
								<span>Help Desk</span>
							</a>
						</h4>
						
						<ul class="list-unstyled">
							<li>
								<a href="#">
									<i class="fa-angle-right"></i>
									Support Center
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa-angle-right"></i>
									Submit a Ticket
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa-angle-right"></i>
									Domains Protocol
								</a>
							</li>
							<li>
								<a href="#">
									<i class="fa-angle-right"></i>
									Terms of Service
								</a>
							</li>
						</ul>
					</div>
					
				</div>
				
			</div>
		
		</div>
		
	</div>
	
	<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->
			
		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
		<div class="sidebar-menu toggle-others fixed">
			
			<div class="sidebar-menu-inner">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="dashboard-1.jsp" class="logo-expanded">
							<img src="pages/assets/images/logo@2x.png" width="80" alt="" />
						</a>
						
						<a href="dashboard-1.jsp" class="logo-collapsed">
							<img src="pages/assets/images/logo-collapsed@2x.png" width="40" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					<div class="mobile-menu-toggle visible-xs">
						<a href="#" data-toggle="user-info-menu">
							<i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a>
						
						<a href="#" data-toggle="mobile-menu">
							<i class="fa-bars"></i>
						</a>
					</div>
					
					<!-- This will open the popup with user profile settings, you can use for any purpose, just be creative -->
					<div class="settings-icon">
						<a href="#" data-toggle="settings-pane" data-animate="true">
							<i class="linecons-cog"></i>
						</a>
					</div>
					
								
				</header>
						
				
						
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li class="opened active">
						<a href="dashboard-1.jsp">
							<i class="linecons-cog"></i>
							<span class="title">Dashboard</span>
						</a>
						<ul>
							<li>
								<a href="dashboard-1.jsp">
									<span class="title">Dashboard 1</span>
								</a>
							</li>
							<li>
								<a href="dashboard-2.jsp">
									<span class="title">Dashboard 2</span>
								</a>
							</li>
							<li class="active">
								<a href="dashboard-3.jsp">
									<span class="title">Dashboard 3</span>
								</a>
							</li>
							<li>
								<a href="dashboard-4.jsp">
									<span class="title">Dashboard 4</span>
								</a>
							</li>
							<li>
								<a href="skin-generator.jsp">
									<span class="title">Skin Generator</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="layout-variants.jsp">
							<i class="linecons-desktop"></i>
							<span class="title">Layouts</span>
						</a>
						<ul>
							<li>
								<a href="layout-variants.jsp">
									<span class="title">Layout Variants &amp; API</span>
								</a>
							</li>
							<li>
								<a href="layout-collapsed-sidebar.jsp">
									<span class="title">Collapsed Sidebar</span>
								</a>
							</li>
							<li>
								<a href="layout-static-sidebar.jsp">
									<span class="title">Static Sidebar</span>
								</a>
							</li>
							<li>
								<a href="layout-horizontal-menu.jsp">
									<span class="title">Horizontal Menu</span>
								</a>
							</li>
							<li>
								<a href="layout-horizontal-plus-sidebar.jsp">
									<span class="title">Horizontal &amp; Sidebar Menu</span>
								</a>
							</li>
							<li>
								<a href="layout-horizontal-menu-click-to-open-subs.jsp">
									<span class="title">Horizontal Open On Click</span>
								</a>
							</li>
							<li>
								<a href="layout-horizontal-menu-min.jsp">
									<span class="title">Horizontal Menu Minimal</span>
								</a>
							</li>
							<li>
								<a href="layout-right-sidebar.jsp">
									<span class="title">Right Sidebar</span>
								</a>
							</li>
							<li>
								<a href="layout-chat-open.jsp">
									<span class="title">Chat Open</span>
								</a>
							</li>
							<li>
								<a href="layout-horizontal-sidebar-menu-collapsed-right.jsp">
									<span class="title">Both Menus &amp; Collapsed</span>
								</a>
							</li>
							<li>
								<a href="layout-boxed.jsp">
									<span class="title">Boxed Layout</span>
								</a>
							</li>
							<li>
								<a href="layout-boxed-horizontal-menu.jsp">
									<span class="title">Boxed &amp; Horizontal Menu</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ui-panels.jsp">
							<i class="linecons-note"></i>
							<span class="title">UI Elements</span>
						</a>
						<ul>
							<li>
								<a href="ui-panels.jsp">
									<span class="title">Panels</span>
								</a>
							</li>
							<li>
								<a href="ui-buttons.jsp">
									<span class="title">Buttons</span>
								</a>
							</li>
							<li>
								<a href="ui-tabs-accordions.jsp">
									<span class="title">Tabs &amp; Accordions</span>
								</a>
							</li>
							<li>
								<a href="ui-modals.jsp">
									<span class="title">Modals</span>
								</a>
							</li>
							<li>
								<a href="ui-breadcrumbs.jsp">
									<span class="title">Breadcrumbs</span>
								</a>
							</li>
							<li>
								<a href="ui-blockquotes.jsp">
									<span class="title">Blockquotes</span>
								</a>
							</li>
							<li>
								<a href="ui-progressbars.jsp">
									<span class="title">Progress Bars</span>
								</a>
							</li>
							<li>
								<a href="ui-navbars.jsp">
									<span class="title">Navbars</span>
								</a>
							</li>
							<li>
								<a href="ui-alerts.jsp">
									<span class="title">Alerts</span>
								</a>
							</li>
							<li>
								<a href="ui-pagination.jsp">
									<span class="title">Pagination</span>
								</a>
							</li>
							<li>
								<a href="ui-typography.jsp">
									<span class="title">Typography</span>
								</a>
							</li>
							<li>
								<a href="ui-other-elements.jsp">
									<span class="title">Other Elements</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="ui-widgets.jsp">
							<i class="linecons-star"></i>
							<span class="title">Widgets</span>
						</a>
					</li>
					<li>
						<a href="mailbox-main.jsp">
							<i class="linecons-mail"></i>
							<span class="title">Mailbox</span>
							<span class="label label-success pull-right">5</span>
						</a>
						<ul>
							<li>
								<a href="mailbox-main.jsp">
									<span class="title">Inbox</span>
								</a>
							</li>
							<li>
								<a href="mailbox-compose.jsp">
									<span class="title">Compose Message</span>
								</a>
							</li>
							<li>
								<a href="mailbox-message.jsp">
									<span class="title">View Message</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="tables-basic.jsp">
							<i class="linecons-database"></i>
							<span class="title">Tables</span>
						</a>
						<ul>
							<li>
								<a href="tables-basic.jsp">
									<span class="title">Basic Tables</span>
								</a>
							</li>
							<li>
								<a href="tables-responsive.jsp">
									<span class="title">Responsive Table</span>
								</a>
							</li>
							<li>
								<a href="tables-datatables.jsp">
									<span class="title">Data Tables</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="forms-native.jsp">
							<i class="linecons-params"></i>
							<span class="title">Forms</span>
						</a>
						<ul>
							<li>
								<a href="forms-native.jsp">
									<span class="title">Native Elements</span>
								</a>
							</li>
							<li>
								<a href="forms-advanced.jsp">
									<span class="title">Advanced Plugins</span>
								</a>
							</li>
							<li>
								<a href="forms-wizard.jsp">
									<span class="title">Form Wizard</span>
								</a>
							</li>
							<li>
								<a href="forms-validation.jsp">
									<span class="title">Form Validation</span>
								</a>
							</li>
							<li>
								<a href="forms-input-masks.jsp">
									<span class="title">Input Masks</span>
								</a>
							</li>
							<li>
								<a href="forms-file-upload.jsp">
									<span class="title">File Upload</span>
								</a>
							</li>
							<li>
								<a href="forms-editors.jsp">
									<span class="title">Editors</span>
								</a>
							</li>
							<li>
								<a href="forms-sliders.jsp">
									<span class="title">Sliders</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="extra-gallery.jsp">
							<i class="linecons-beaker"></i>
							<span class="title">Extra</span>
							<span class="label label-purple pull-right hidden-collapsed">New Items</span>
						</a>
						<ul>
							<li>
								<a href="extra-icons-fontawesome.jsp">
									<span class="title">Icons</span>
									<span class="label label-warning pull-right">4</span>
								</a>
								<ul>
									<li>
										<a href="extra-icons-fontawesome.jsp">
											<span class="title">Font Awesome</span>
										</a>
									</li>
									<li>
										<a href="extra-icons-linecons.jsp">
											<span class="title">Linecons</span>
										</a>
									</li>
									<li>
										<a href="extra-icons-elusive.jsp">
											<span class="title">Elusive</span>
										</a>
									</li>
									<li>
										<a href="extra-icons-meteocons.jsp">
											<span class="title">Meteocons</span>
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="extra-maps-google.jsp">
									<span class="title">Maps</span>
								</a>
								<ul>
									<li>
										<a href="extra-maps-google.jsp">
											<span class="title">Google Maps</span>
										</a>
									</li>
									<li>
										<a href="extra-maps-advanced.jsp">
											<span class="title">Advanced Map</span>
										</a>
									</li>
									<li>
										<a href="extra-maps-vector.jsp">
											<span class="title">Vector Map</span>
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="extra-gallery.jsp">
									<span class="title">Gallery</span>
								</a>
							</li>
							<li>
								<a href="extra-calendar.jsp">
									<span class="title">Calendar</span>
								</a>
							</li>
							<li>
								<a href="extra-profile.jsp">
									<span class="title">Profile</span>
								</a>
							</li>
							<li>
								<a href="extra-login.jsp">
									<span class="title">Login</span>
								</a>
							</li>
							<li>
								<a href="extra-lockscreen.jsp">
									<span class="title">Lockscreen</span>
								</a>
							</li>
							<li>
								<a href="extra-login-light.jsp">
									<span class="title">Login Light</span>
								</a>
							</li>
							<li>
								<a href="extra-timeline.jsp">
									<span class="title">Timeline</span>
								</a>
							</li>
							<li>
								<a href="extra-timeline-center.jsp">
									<span class="title">Timeline Centerd</span>
								</a>
							</li>
							<li>
								<a href="extra-notes.jsp">
									<span class="title">Notes</span>
								</a>
							</li>
							<li>
								<a href="extra-image-crop.jsp">
									<span class="title">Image Crop</span>
								</a>
							</li>
							<li>
								<a href="extra-portlets.jsp">
									<span class="title">Portlets</span>
								</a>
							</li>
							<li>
								<a href="blank-sidebar.jsp">
									<span class="title">Blank Page</span>
								</a>
							</li>
							<li>
								<a href="extra-search.jsp">
									<span class="title">Search</span>
								</a>
							</li>
							<li>
								<a href="extra-invoice.jsp">
									<span class="title">Invoice</span>
								</a>
							</li>
							<li>
								<a href="extra-not-found.jsp">
									<span class="title">404 Page</span>
								</a>
							</li>
							<li>
								<a href="extra-tocify.jsp">
									<span class="title">Tocify</span>
								</a>
							</li>
							<li>
								<a href="extra-loader.jsp">
									<span class="title">Loading Progress</span>
								</a>
							</li>
							<li>
								<a href="extra-page-loading-ol.jsp">
									<span class="title">Page Loading Overlay</span>
								</a>
							</li>
							<li>
								<a href="extra-notifications.jsp">
									<span class="title">Notifications</span>
								</a>
							</li>
							<li>
								<a href="extra-nestable-lists.jsp">
									<span class="title">Nestable Lists</span>
								</a>
							</li>
							<li>
								<a href="extra-scrollable.jsp">
									<span class="title">Scrollable</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="charts-main.jsp">
							<i class="linecons-globe"></i>
							<span class="title">Charts</span>
						</a>
						<ul>
							<li>
								<a href="charts-main.jsp">
									<span class="title">Chart Variants</span>
								</a>
							</li>
							<li>
								<a href="charts-range.jsp">
									<span class="title">Range Selector</span>
								</a>
							</li>
							<li>
								<a href="charts-sparklines.jsp">
									<span class="title">Sparklines</span>
								</a>
							</li>
							<li>
								<a href="charts-map.jsp">
									<span class="title">Map Charts</span>
								</a>
							</li>
							<li>
								<a href="charts-gauges.jsp">
									<span class="title">Circular Gauges</span>
								</a>
							</li>
							<li>
								<a href="charts-bar-gauges.jsp">
									<span class="title">Bar Gauges</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">
							<i class="linecons-cloud"></i>
							<span class="title">Menu Levels</span>
						</a>
						<ul>
							<li>
								<a href="#">
									<i class="entypo-flow-line"></i>
									<span class="title">Menu Level 1.1</span>
								</a>
								<ul>
									<li>
										<a href="#">
											<i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.1</span>
										</a>
									</li>
									<li>
										<a href="#">
											<i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.2</span>
										</a>
										<ul>
											<li>
												<a href="#">
													<i class="entypo-flow-cascade"></i>
													<span class="title">Menu Level 3.1</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="entypo-flow-cascade"></i>
													<span class="title">Menu Level 3.2</span>
												</a>
												<ul>
													<li>
														<a href="#">
															<i class="entypo-flow-branch"></i>
															<span class="title">Menu Level 4.1</span>
														</a>
													</li>
												</ul>
											</li>
										</ul>
									</li>
									<li>
										<a href="#">
											<i class="entypo-flow-parallel"></i>
											<span class="title">Menu Level 2.3</span>
										</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#">
									<i class="entypo-flow-line"></i>
									<span class="title">Menu Level 1.2</span>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="entypo-flow-line"></i>
									<span class="title">Menu Level 1.3</span>
								</a>
							</li>
						</ul>
					</li>
				</ul>
						
			</div>
			
		</div>
		
		<div class="main-content">
					
			<!-- User Info, Notifications and Menu Bar -->
			<nav class="navbar user-info-navbar" role="navigation">
				
				<!-- Left links for user info navbar -->
				<ul class="user-info-menu left-links list-inline list-unstyled">
					
					<li class="hidden-sm hidden-xs">
						<a href="#" data-toggle="sidebar">
							<i class="fa-bars"></i>
						</a>
					</li>
					
					<li class="dropdown hover-line">
						<a href="#" data-toggle="dropdown">
							<i class="fa-envelope-o"></i>
							<span class="badge badge-green">15</span>
						</a>
							
						<ul class="dropdown-menu messages">
							<li>
									
								<ul class="dropdown-menu-list list-unstyled ps-scrollbar">
								
									<li class="active"><!-- "active" class means message is unread -->
										<a href="#">
											<span class="line">
												<strong>Luc Chartier</strong>
												<span class="light small">- yesterday</span>
											</span>
											
											<span class="line desc small">
												This ain’t our first item, it is the best of the rest.
											</span>
										</a>
									</li>
									
									<li class="active">
										<a href="#">
											<span class="line">
												<strong>Salma Nyberg</strong>
												<span class="light small">- 2 days ago</span>
											</span>
											
											<span class="line desc small">
												Oh he decisively impression attachment friendship so if everything. 
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Hayden Cartwright
												<span class="light small">- a week ago</span>
											</span>
											
											<span class="line desc small">
												Whose her enjoy chief new young. Felicity if ye required likewise so doubtful.
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Sandra Eberhardt
												<span class="light small">- 16 days ago</span>
											</span>
											
											<span class="line desc small">
												On so attention necessary at by provision otherwise existence direction.
											</span>
										</a>
									</li>
									
									<!-- Repeated -->
									
									<li class="active"><!-- "active" class means message is unread -->
										<a href="#">
											<span class="line">
												<strong>Luc Chartier</strong>
												<span class="light small">- yesterday</span>
											</span>
											
											<span class="line desc small">
												This ain’t our first item, it is the best of the rest.
											</span>
										</a>
									</li>
									
									<li class="active">
										<a href="#">
											<span class="line">
												<strong>Salma Nyberg</strong>
												<span class="light small">- 2 days ago</span>
											</span>
											
											<span class="line desc small">
												Oh he decisively impression attachment friendship so if everything. 
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Hayden Cartwright
												<span class="light small">- a week ago</span>
											</span>
											
											<span class="line desc small">
												Whose her enjoy chief new young. Felicity if ye required likewise so doubtful.
											</span>
										</a>
									</li>
									
									<li>
										<a href="#">
											<span class="line">
												Sandra Eberhardt
												<span class="light small">- 16 days ago</span>
											</span>
											
											<span class="line desc small">
												On so attention necessary at by provision otherwise existence direction.
											</span>
										</a>
									</li>
									
								</ul>
								
							</li>
							
							<li class="external">
								<a href="blank-sidebar.jsp">
									<span>All Messages</span>
									<i class="fa-link-ext"></i>
								</a>
							</li>
						</ul>
					</li>
					
					<li class="dropdown hover-line">
						<a href="#" data-toggle="dropdown">
							<i class="fa-bell-o"></i>
							<span class="badge badge-purple">7</span>
						</a>
							
						<ul class="dropdown-menu notifications">
							<li class="top">
								<p class="small">
									<a href="#" class="pull-right">Mark all Read</a>
									You have <strong>3</strong> new notifications.
								</p>
							</li>
							
							<li>
								<ul class="dropdown-menu-list list-unstyled ps-scrollbar">
									<li class="active notification-success">
										<a href="#">
											<i class="fa-user"></i>
											
											<span class="line">
												<strong>New user registered</strong>
											</span>
											
											<span class="line small time">
												30 seconds ago
											</span>
										</a>
									</li>
									
									<li class="active notification-secondary">
										<a href="#">
											<i class="fa-lock"></i>
											
											<span class="line">
												<strong>Privacy settings have been changed</strong>
											</span>
											
											<span class="line small time">
												3 hours ago
											</span>
										</a>
									</li>
									
									<li class="notification-primary">
										<a href="#">
											<i class="fa-thumbs-up"></i>
											
											<span class="line">
												<strong>Someone special liked this</strong>
											</span>
											
											<span class="line small time">
												2 minutes ago
											</span>
										</a>
									</li>
									
									<li class="notification-danger">
										<a href="#">
											<i class="fa-calendar"></i>
											
											<span class="line">
												John cancelled the event
											</span>
											
											<span class="line small time">
												9 hours ago
											</span>
										</a>
									</li>
									
									<li class="notification-info">
										<a href="#">
											<i class="fa-database"></i>
											
											<span class="line">
												The server is status is stable
											</span>
											
											<span class="line small time">
												yesterday at 10:30am
											</span>
										</a>
									</li>
									
									<li class="notification-warning">
										<a href="#">
											<i class="fa-envelope-o"></i>
											
											<span class="line">
												New comments waiting approval
											</span>
											
											<span class="line small time">
												last week
											</span>
										</a>
									</li>
								</ul>
							</li>
							
							<li class="external">
								<a href="#">
									<span>View all notifications</span>
									<i class="fa-link-ext"></i>
								</a>
							</li>
						</ul>
					</li>
					
				</ul>
				
				
				<!-- Right links for user info navbar -->
				<ul class="user-info-menu right-links list-inline list-unstyled">
					
					<li class="search-form"><!-- You can add "always-visible" to show make the search input visible -->
						
						<form method="get" action="extra-search.jsp">
							<input type="text" name="s" class="form-control search-field" placeholder="Type to search..." />
							
							<button type="submit" class="btn btn-link">
								<i class="linecons-search"></i>
							</button>
						</form>
						
					</li>
					
					<li class="dropdown user-profile">
						<a href="#" data-toggle="dropdown">
							<img src="pages/assets/images/user-4.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
							<span>
								Arlind Nushi
								<i class="fa-angle-down"></i>
							</span>
						</a>
						
						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<li>
								<a href="#edit-profile">
									<i class="fa-edit"></i>
									New Post
								</a>
							</li>
							<li>
								<a href="#settings">
									<i class="fa-wrench"></i>
									Settings
								</a>
							</li>
							<li>
								<a href="#profile">
									<i class="fa-user"></i>
									Profile
								</a>
							</li>
							<li>
								<a href="#help">
									<i class="fa-info"></i>
									Help
								</a>
							</li>
							<li class="last">
								<a href="extra-lockscreen.jsp">
									<i class="fa-lock"></i>
									Logout
								</a>
							</li>
						</ul>
					</li>
					
					<li>
						<a href="#" data-toggle="chat">
							<i class="fa-comments-o"></i>
						</a>
					</li>
					
				</ul>
				
			</nav>
			
			<script type="text/javascript">
				jQuery(document).ready(function($)
				{
					var xenonPalette = ['#68b828','#7c38bc','#0e62c7','#fcd036','#4fcdfc','#00b19d','#ff6264','#f7aa47'];
					
					// Doughnut 1
					var doughnut1_data_source = [
						{region: "Asia", val: 4119626293},
						{region: "Africa", val: 1012956064},
						{region: "Northern America", val: 344124520},
						{region: "Latin America and the Caribbean", val: 590946440},
						{region: "Europe", val: 727082222},
						{region: "Oceania", val: 35104756},
						{region: "Oceania 1", val: 727082222},
						{region: "Oceania 3", val: 727082222},
						{region: "Oceania 4", val: 727082222},
						{region: "Oceania 5", val: 727082222},
					], timer;
					
					$("#doughnut-1").dxPieChart({
						dataSource: doughnut1_data_source,
						tooltip: {
							enabled: false,
						  	format:"millions",
							customizeText: function() { 
								return this.argumentText + "<br/>" + this.valueText;
							}
						},
						size: {
							height: 130
						},
						legend: {
							visible: false
						},  
						series: [{
							type: "doughnut",
							argumentField: "region"
						}],
						palette: xenonPalette
					});
					
					
					// Area Chart 2
					var doughnut2_data_source = [
						{ id: 0, x1: 0 },
						{ id: 1, x1: 2 },
						{ id: 2, x1: 3 },
						{ id: 3, x1: 5 },
						{ id: 4, x1: 7 },
						{ id: 5, x1: 3 },
						{ id: 6, x1: 1 },
						{ id: 7, x1: 2 },
						{ id: 8, x1: 5 },
						{ id: 9, x1: 4 },
					];
					
					$("#area-2").dxChart({
						dataSource: doughnut2_data_source,
						commonSeriesSettings: {
							type: "area",
							argumentField: "id"
						},
						series: [
							{ valueField: "x1", name: "15-64 years", color: '#7c38bc', opacity: .7 },
						],
						argumentAxis:{
							valueMarginsEnabled: false
						},
						valueAxis:{
							label: {
								format: "millions"
							}
						},
						legend: {
							verticalAlignment: "bottom",
							horizontalAlignment: "center"
						},
						legend: {
							visible: false
						},
						commonAxisSettings: {
							label: {
								visible: false
							},
							grid: {
								visible: false
							}
						},
						margin: {
							bottom: 0,
							top: 30
						}
					});
					
					
					// Sparklines
					var visitsOptions = {
						dataSource: getVisits(),
						argumentField: 'month',
						valueField: '2010',
						type: 'line',
						showMinMax: true,
						lineColor: '#f7aa47',
						minColor: '#4fcdfc',
						maxColor: '#d5080f',
					},
					bounceOptions = {
						dataSource: getBounceRate(),
						argumentField: 'month',
						valueField: '2010',
						type: 'spline',
						lineWidth: 3,
						lineColor: '#68b828',
						minColor: '#00b19d',
						maxColor: '#7c38bc',
						showMinMax: true,
						showFirstLast: false
					},
					viewsOptions = {
						dataSource: getPageviews(),
						argumentField: 'month',
						valueField: '2010',
						lineColor: '#7c38bc',
						firstLastColor: '#ccc',
						pointSize: 6,
						pointSymbol: 'square',
						pointColor: '#333',
						type: 'stepline'
					};
					
					function getVisits() {
						return [{ month: 1, 2010: 77, 2011: 93, 2012: 107 },
						{ month: 2, 2010: 72, 2011: 101, 2012: 112 },
						{ month: 3, 2010: 79, 2011: 115, 2012: 123 },
						{ month: 4, 2010: 82, 2011: 116, 2012: 123 },
						{ month: 5, 2010: 86, 2011: 124, 2012: 116 },
						{ month: 6, 2010: 73, 2011: 115, 2012: 102 },
						{ month: 7, 2010: 73, 2011: 110, 2012: 94 },
						{ month: 8, 2010: 77, 2011: 117, 2012: 105 },
						{ month: 9, 2010: 76, 2011: 113, 2012: 113 },
						{ month: 10, 2010: 81, 2011: 103, 2012: 111 },
						{ month: 11, 2010: 83, 2011: 110, 2012: 107 },
						{ month: 12, 2010: 89, 2011: 109, 2012: 110 }];
					}
					function getBounceRate() {
						return [{ month: 1, 2010: 1115, 2011: 1358, 2012: 1661 },
						{ month: 2, 2010: 1099, 2011: 1375, 2012: 1742 },
						{ month: 3, 2010: 1114, 2011: 1423, 2012: 1677 },
						{ month: 4, 2010: 1150, 2011: 1486, 2012: 1650 },
						{ month: 5, 2010: 1205, 2011: 1511, 2012: 1589 },
						{ month: 6, 2010: 1235, 2011: 1529, 2012: 1602 },
						{ month: 7, 2010: 1193, 2011: 1573, 2012: 1593 },
						{ month: 8, 2010: 1220, 2011: 1765, 2012: 1634 },
						{ month: 9, 2010: 1272, 2011: 1771, 2012: 1750 },
						{ month: 10, 2010: 1345, 2011: 1672, 2012: 1745 },
						{ month: 11, 2010: 1370, 2011: 1741, 2012: 1720 },
						{ month: 12, 2010: 1392, 2011: 1643, 2012: 1684 }];
					};
					function getPageviews() {
						 return [{ month: 1, 2010: 17, 2011: 30, 2012: 27 },
						{ month: 2, 2010: 28, 2011: 28, 2012: 33 },
						{ month: 3, 2010: 34, 2011: 34, 2012: 35 },
						{ month: 4, 2010: 37, 2011: 37, 2012: 32 },
						{ month: 5, 2010: 47, 2011: 47, 2012: 30 },
						{ month: 6, 2010: 37, 2011: 37, 2012: 28 },
						{ month: 7, 2010: 34, 2011: 34, 2012: 27 },
						{ month: 8, 2010: 40, 2011: 40, 2012: 27 },
						{ month: 9, 2010: 41, 2011: 41, 2012: 31 },
						{ month: 10, 2010: 30, 2011: 30, 2012: 34 },
						{ month: 11, 2010: 34, 2011: 34, 2012: 31 },
						{ month: 12, 2010: 32, 2011: 32, 2012: 33 }];
					 };
					
					$('.line2010').dxSparkline(visitsOptions);
					$('.spline2010').dxSparkline(bounceOptions);
					$('.stepline2010').dxSparkline(viewsOptions);
					
					
					// Age Group
					var options = {
						startScaleValue: 0,
						endScaleValue: 35,
						tooltip: {
							customizeText: function() {
								return 'Current t&#176: ' + this.value + '&#176C<br>' + 'Average t&#176: ' + this.target + '&#176C';
							}
						}
					};
					
					var agroup_1 = $.extend({ value: 23, target: 25, color: '#68b828' }, options),
						agroup_2 = $.extend({ value: 27, target: 25, color: '#4fcdfc' }, options),
						agroup_3 = $.extend({ value: 20, target: 15, color: '#d5080f' }, options);
					
					$('#age-group-1').dxBullet(agroup_1);
					$('#age-group-2').dxBullet(agroup_2);
					$('#age-group-3').dxBullet(agroup_3);
				});
				
			</script>
			
			<div class="row">
				<div class="col-sm-12">
					
					<div class="chart-item-bg-2">
						<div class="chart-item-num" data-count="this" data-from="0" data-to="98" data-suffix="%" data-duration="2">0%</div>
						<div class="chart-item-desc">
							<p class="col-lg-7">Carriage quitting securing be appetite it declared. High eyes kept so busy feel call in.</p>
						</div>
						<div class="chart-item-env">
							<div id="doughnut-1" style="width: 200px;"></div>
						</div>
					</div>
					
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-6">
					
					<div class="panel panel-default">
						<div class="panel-heading">This Week Analytics</div>
						<table class="table">
							<thead>
								<tr>
									<th>Type</th>
									<th width="20%">Sum</th>
									<th width="50%">Weekly Chart</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Visits</td>
									<td>23,670</td>
									<td>
										<div class="sparkline line2010"></div>
									</td>
								</tr>
								<tr>
									<td>Bounce Rate</td>
									<td>37,5%</td>
									<td>
										<div class="sparkline spline2010"></div>
									</td>
								</tr>
								<tr>
									<td>Page views</td>
									<td>107,221</td>
									<td>
										<div class="sparkline stepline2010"></div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
				</div>
				<div class="col-sm-6">
					
					<div class="panel panel-default">
						<div class="panel-heading">Average Age Group</div>
						<table class="table">
							<thead>
								<tr>
									<th>Group</th>
									<th width="20%">Pct</th>
									<th width="20%">Target</th>
									<th width="40%">Chart</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>18-24</td>
									<td>42,17%</td>
									<td>50%</td>
									<td>
										<div id="age-group-1" class="sparkline"></div>
									</td>
								</tr>
								<tr>
									<td>25-35</td>
									<td>29,50%</td>
									<td>26%</td>
									<td>
										<div id="age-group-2" class="sparkline"></div>
									</td>
								</tr>
								<tr>
									<td>36-50</td>
									<td>28.33%</td>
									<td>24%</td>
									<td>
										<div id="age-group-3" class="sparkline"></div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-sm-12">
					
					<div class="chart-item-bg-2">
						<div class="chart-item-num num-sm" style="width: 370px;" data-count="this" data-from="0" data-to="112.34" data-decimal="," data-suffix="%" data-duration="3">0%</div>
						<div class="chart-item-env no-padding">
							<div id="area-2" style="height: 150px; margin: 0"></div>
						</div>
					</div>
					
				</div>
			</div>
			
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">EU Greenhouse Gas Emissions</h3>
					<div class="panel-options">
						<a href="#" data-toggle="panel">
							<span class="collapse-icon">&ndash;</span>
							<span class="expand-icon">+</span>
						</a>
						<a href="#" data-toggle="remove">
							&times;
						</a>
					</div>
				</div>
				<div class="panel-body">
					
					<div class="row">
						<div class="col-sm-6">
							
							<script type="text/javascript">
								jQuery(document).ready(function($)
								{
									var map = $("#italy");
										map.vectorMap({
											map: 'it_mill_en',
											backgroundColor: '#FFF',
											normalizeFunction: 'polynomial',
											markersSelectable: true,
											regionStyle: {
											  initial: {
												"fill": '#ebebeb',
												"fill-opacity": 0.9,
												"stroke": '#ccc',
												"stroke-width": 1,
												"stroke-opacity": 1
											  },
											  hover: {
												"fill-opacity": 1,
												"fill": "#ddd"
											  }
											},
											markerStyle: {
												initial: {
													fill: '#68b828',
													"stroke": "#fff"
												},
												selected: {
													fill: '#7c38bc'
												}
											},
											markers: [
												{latLng: [41.87, 12.48], name: 'Rome'},
												{latLng: [45.46, 9.18], name: 'Milan'},
												{latLng: [41.11, 16.87], name: 'Bari'},
												{latLng: [37.51, 15.08], name: 'Catania'},
											]
										});
								});
							</script>
							
							<div id="italy" style="height: 380px;"></div>
							
						</div>
						<div class="col-sm-6">
							<strong class="text-primary h3">Examining Country &ndash; Italy</strong>
							<br />
							<br />
							<p>Proper resources reduce carbon emissions resolve crisis situation, advocate, innovation.</p>
							
							<div class="vspacer v3"></div>
							
							<div class="label label-secondary">FQ 2014</div>
			
							<ul class="list-unstyled list-margin">
								<li>Carbon Emission: <strong>3.18</strong> Tonnes CO2</li>
								<li>Reduction from previous year: <strong>20.7%</strong> g/km</li>
								<li>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-info" style="width: 42.5%;"></div>
									</div>
								</li>
							</ul>
							
							
							<div class="label label-secondary">LQ 2013</div>
			
							<ul class="list-unstyled list-margin">
								<li>Carbon Emission: <strong>6.42</strong> Tonnes CO2</li>
								<li>Reduction from previous year: <strong>15.9%</strong> g/km</li>
								<li>
									<div class="progress progress-striped active">
										<div class="progress-bar progress-bar-warning" style="width: 65.4%;"></div>
									</div>
								</li>
							</ul>
							
						</div>
					</div>
					
				</div>
			</div>
			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<footer class="main-footer sticky footer-type-1">
				
				<div class="footer-inner">
				
					<!-- Add your copyright text here -->
					<div class="footer-text">
						&copy; 2014 
						<strong>Xenon</strong> 
						theme by <a href="http://laborator.co" target="_blank">Laborator</a>
					</div>
					
					
					<!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
					<div class="go-up">
					
						<a href="#" rel="go-top">
							<i class="fa-angle-up"></i>
						</a>
						
					</div>
					
				</div>
				
			</footer>
		</div>
		
			
		<!-- start: Chat Section -->
		<div id="chat" class="fixed">
			
			<div class="chat-inner">
			
				
				<h2 class="chat-header">
					<a href="#" class="chat-close" data-toggle="chat">
						<i class="fa-plus-circle rotate-45deg"></i>
					</a>
					
					Chat
					<span class="badge badge-success is-hidden">0</span>
				</h2>
				
				<script type="text/javascript">
				// Here is just a sample how to open chat conversation box
				jQuery(document).ready(function($)
				{
					var $chat_conversation = $(".chat-conversation");
					
					$(".chat-group a").on('click', function(ev)
					{
						ev.preventDefault();
						
						$chat_conversation.toggleClass('is-open');
						
						$(".chat-conversation textarea").trigger('autosize.resize').focus();
					});
					
					$(".conversation-close").on('click', function(ev)
					{
						ev.preventDefault();
						$chat_conversation.removeClass('is-open');
					});
				});
				</script>
				
				
				<div class="chat-group">
					<strong>Favorites</strong>
					
					<a href="#"><span class="user-status is-online"></span> <em>Catherine J. Watkins</em></a>
					<a href="#"><span class="user-status is-online"></span> <em>Nicholas R. Walker</em></a>
					<a href="#"><span class="user-status is-busy"></span> <em>Susan J. Best</em></a>
					<a href="#"><span class="user-status is-idle"></span> <em>Fernando G. Olson</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Brandon S. Young</em></a>
				</div>
				
				
				<div class="chat-group">
					<strong>Work</strong>
					
					<a href="#"><span class="user-status is-busy"></span> <em>Rodrigo E. Lozano</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Robert J. Garcia</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Daniel A. Pena</em></a>
				</div>
				
				
				<div class="chat-group">
					<strong>Other</strong>
					
					<a href="#"><span class="user-status is-online"></span> <em>Dennis E. Johnson</em></a>
					<a href="#"><span class="user-status is-online"></span> <em>Stuart A. Shire</em></a>
					<a href="#"><span class="user-status is-online"></span> <em>Janet I. Matas</em></a>
					<a href="#"><span class="user-status is-online"></span> <em>Mindy A. Smith</em></a>
					<a href="#"><span class="user-status is-busy"></span> <em>Herman S. Foltz</em></a>
					<a href="#"><span class="user-status is-busy"></span> <em>Gregory E. Robie</em></a>
					<a href="#"><span class="user-status is-busy"></span> <em>Nellie T. Foreman</em></a>
					<a href="#"><span class="user-status is-busy"></span> <em>William R. Miller</em></a>
					<a href="#"><span class="user-status is-idle"></span> <em>Vivian J. Hall</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Melinda A. Anderson</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Gary M. Mooneyham</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Robert C. Medina</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Dylan C. Bernal</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Marc P. Sanborn</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Kenneth M. Rochester</em></a>
					<a href="#"><span class="user-status is-offline"></span> <em>Rachael D. Carpenter</em></a>
				</div>
			
			</div>
			
			<!-- conversation template -->
			<div class="chat-conversation">
				
				<div class="conversation-header">
					<a href="#" class="conversation-close">
						&times;
					</a>
					
					<span class="user-status is-online"></span>
					<span class="display-name">Arlind Nushi</span> 
					<small>Online</small>
				</div>
				
				<ul class="conversation-body">	
					<li>
						<span class="user">Arlind Nushi</span>
						<span class="time">09:00</span>
						<p>Are you here?</p>
					</li>
					<li class="odd">
						<span class="user">Brandon S. Young</span>
						<span class="time">09:25</span>
						<p>This message is pre-queued.</p>
					</li>
					<li>
						<span class="user">Brandon S. Young</span>
						<span class="time">09:26</span>
						<p>Whohoo!</p>
					</li>
					<li class="odd">
						<span class="user">Arlind Nushi</span>
						<span class="time">09:27</span>
						<p>Do you like it?</p>
					</li>
				</ul>
				
				<div class="chat-textarea">
					<textarea class="form-control autogrow" placeholder="Type your message"></textarea>
				</div>
				
			</div>
			
		</div>
		<!-- end: Chat Section -->
		
		
	</div>
	
	
	<div class="page-loading-overlay">
		<div class="loader-2"></div>
	</div>
	




	<!-- Imported styles on this page -->
	<link rel="stylesheet" href="pages/assets/js/devexpress-web-14.1/css/dx.common.css">
	<link rel="stylesheet" href="pages/assets/js/devexpress-web-14.1/css/dx.light.css">

	<!-- Bottom Scripts -->
	<script src="pages/assets/js/bootstrap.min.js"></script>
	<script src="pages/assets/js/TweenMax.min.js"></script>
	<script src="pages/assets/js/resizeable.js"></script>
	<script src="pages/assets/js/joinable.js"></script>
	<script src="pages/assets/js/xenon-api.js"></script>
	<script src="pages/assets/js/xenon-toggles.js"></script>


	<!-- Imported scripts on this page -->
	<script src="pages/assets/js/xenon-widgets.js"></script>
	<script src="pages/assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="pages/assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>
	<script src="pages/assets/js/jvectormap/regions/jquery-jvectormap-it-mill-en.js"></script>
	<script src="pages/assets/js/devexpress-web-14.1/js/globalize.min.js"></script>
	<script src="pages/assets/js/devexpress-web-14.1/js/dx.webappjs.js"></script>
	<script src="pages/assets/js/devexpress-web-14.1/js/dx.chartjs.js"></script>


	<!-- JavaScripts initializations and stuff -->
	<script src="pages/assets/js/xenon-custom.js"></script>

</body>
</html>