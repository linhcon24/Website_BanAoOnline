<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 9/27/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="https://kit.fontawesome.com/999051c9de.js"
        crossorigin="anonymous"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/views/css/contact.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/views/css/style.css">
<script src="./views/js/contact.js"></script>

<br>
<h1 class="giua"><i class="fa-solid fa-phone"></i>Contact</h1>
<br>
<section class="content-page">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div id="map" class="map style1 mb-45">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.697706734468!2d105.7463187748494!3d21.044778187229007!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454edc7aef2a9%3A0x4e9843ec832913c8!2zNDggTmcuIDk5IMSQLiBD4bqndSBEaeG7hW4sIFBow7pjIERp4buFbiwgVOG7qyBMacOqbSwgSMOgIE7hu5lpLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1695793883089!5m2!1svi!2s"
                            width="1108" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 mb-xs-30">
                <h2 class="normal"><span>Stay In Touch</span></h2>
                <p class="mb-25">Lorem ipsum dolor sit amet, consectetur adipiscing elit, eiusmod tempor incididunt ut labore et dolore magna aliqua. Lorem ipsum dolor sit amet.</p>


                <h6>Contact Information</h6>
                <ul class="Contact-information mb-25">
                    <li><i class="fa fa-envelope" aria-hidden="true"></i>info@sky.com</li>
                    <li><i class="fa fa-phone" aria-hidden="true"></i>(013) 456789</li>
                </ul>
                <hr />
                <div class="product-share mtb-30">
                    <ul class="list-none">
                        <li><a href="https://www.facebook.com/" target="_blank"><i class="fa fa-facebook"></i></a></li>

                        <li><a href="http://plus.google.com/" target="_blank"><i class="fa fa-google-plus"></i></a></li>

                    </ul>
                </div>

            </div>
            <div class="col-md-6 offset-md-2">
                <h2 class="normal"><span>Contact Us</span></h2>
                <form class="contact-form">
                    <div class="form-field-wrapper">
                        <label>Your Name <span class="required">*</span></label>
                        <input id="name" class="input-md form-full-width" name="name" placeholder=" EnterYour Name" value="" size="30" aria-required="true" required type="text">
                    </div>
                    <div class="form-field-wrapper">
                        <label>Your Email <span class="required">*</span></label>
                        <input id="email" class="input-md form-full-width" name="email" placeholder="Enter Your Email Address" value="" size="30" aria-required="true" required type="email">
                    </div>
                    <div class="form-field-wrapper">
                        <label>Your subject <span class="required">*</span></label>
                        <input id="subject" class="input-md form-full-width" name="subject" placeholder="Enter Your Subject " value="" size="30" aria-required="true" required type="text">
                    </div>
                    <div class="form-field-wrapper">
                        <label>Message<span class="required">*</span></label>
                        <textarea id="message" class="form-full-width" name="message" placeholder="Enter Your Message" cols="45" rows="8" aria-required="true" required=""></textarea>
                    </div>
                    <div class="form-field-wrapper">
                        <input name="submit" id="submit" class="submit btn btn-md btn-color" value="Submit" type="submit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
