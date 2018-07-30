<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown {
    float: left;
    overflow: hidden;
}

.dropdown .dropbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {
    background-color: #ddd;
}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
<img src="../images/banner.jpg"/>
<div class="navbar">
  <a href="#home">Home</a>
  
  
  <!-- Location Start-->
  <div class="dropdown">
    <button class="dropbtn">LOCATION 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regloc">Register</a>
      <a href="viewAllLocs">View All</a>
      <a href="locReports">Reports</a>
    </div>
  </div> 
  <!-- Location End -->
  
  <!-- Vendor Start-->
  <div class="dropdown">
    <button class="dropbtn">VENDOR 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regven">Register</a>
      <a href="viewAllvendors">View All</a>
      <a href="vendorReports">Reports</a>
      <a href="venLocReports">VendorLocReports</a>
    </div>
  </div> 
  <!-- Vendor End -->
  
  
  <!-- Customer Start -->
  <div class="dropdown">
    <button class="dropbtn">CUSTOMER 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regcust">Register</a>
      <a href="viewAllCustomer">View All</a>
      <a href="customerReports">Reports</a>
      <a href="custLocReports">CUSTOMERLOCReports</a>
    </div>
  </div> 
  <!-- Customer End -->
  <!-- ITEM Start -->
  <div class="dropdown">
    <button class="dropbtn">ITEM
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="regitem">Register</a>
      <a href="#">View All</a>
      <a href="#">Reports</a>
      
    </div>
  </div> 
  <!-- ITEM End -->
  <!-- order Start -->
  <div class="dropdown">
    <button class="dropbtn">ORDER
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Register</a>
      <a href="#">View ORDER</a>
      <a href="#">Reports</a>
      
    </div>
  </div> 
  <!-- orderEnd -->
  
  	<!-- DOCUMENT Menu options -->
	<a href="showDocs">Document</a>
	<!-- DOCUMENT Menu options END -->
  	
  
  
  
</div>
