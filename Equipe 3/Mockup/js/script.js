(function($){
	$(window).load(function() {
		"use strict";
		if ($.fn.blueberry) {
			$('#slider-img').blueberry();
		};
	});
	$(document).ready(function(){
		"use strict";
		// to switch between the tabs for the main form
		$(".title-form").click(function() {
			var this_id = $( this ).attr('id');
			$( this ).parents('form').filter(':first').children('.main_form_navigation').children('.title-form').addClass('back').removeClass('current');
			$( this ).addClass("current").removeClass('back');
			$( this ).parents('form').filter(':first').children(".content-form").addClass("hidden");
			$("#"+this_id+"_content").removeClass('hidden');			
		});
		/* add placeholder in ie */
		if ( $.browser.msie && $.fn.placeholder ) {
			$('.location, #sign_up_name, #sign_up_email, .form_element input, .shortcode_input, .input_placeholder').placeholder();
		}
		// custom select 
		$(".select").selectbox();
		$(".select:disabled").selectbox("disable");

		// custom slider 
		$(".price_range").slider({
		  from: 0,
		  to: 1500,
		  step: 50,
		  dimension: '&nbsp;$'
		});
		$(".passangers_range").slider({
		  from: 1,
		  to: 5,
		  step: 1,
		  dimension: ''
		});
		$(".shortcode_range").slider({
		  to: 5,
		  step: 1,
		  dimension: ''
		});

		// hide/show 'more details'
		$(".details-more").css('display','none');
		$(".view-details").click(function(){
			$( this ).css('display','none');
			$( this ).closest('.main-block').find('.close-details').css('display','block');
			$( this ).closest('.main-block').find('.details-more').css('display','block');
		});
		$(".close-details").click(function(){
			$( this ).css('display','none');
			$( this ).closest('.main-block').find('.view-details').css('display','block');
			$( this ).closest('.main-block').find('.details-more').css('display','none');
		});
		$(".details div").hover(function(){
			$( this ).css('color','#EE7835');
		},function(){
			$( this ).css('color','#378EEF');
		});

		// change overlay block height for register/sign_in/reset_password pages
		$("#overlay_block").css('height', $(document).height() );
		$(".admin-form-content").click(function(event){
			if ($(event.target).closest(".admin-form-block").length) return;
		    $("#overlay_block").css('display','none');
			$(".admin-form-content").css('display','none');
		    event.stopPropagation();						
		});
		// to switch between the tabs for the sign_in/register form
		var name = window.location.hash.replace("#","");
		if ( name != "" ) {
			$(".admin-form .title-form").addClass('back').removeClass('current');
			$(".admin-form #tab_"+name).addClass("current").removeClass('back');
			$(".admin-form .content-form").addClass("hidden");
			$(".admin-form #tab_"+name+"_content").removeClass('hidden');
		}
		$( ".tab_link_button" ).click( function() {
			$( "#overlay_block" ).css( 'display','block' );			
			var this_id = $( this ).parent( 'span' ).attr( 'class' ).toLowerCase().replace( ' ','_' );			
			if ( this_id == 'forgot_passwd' ) {
				$( ".admin-form-content" ).css( 'display','none' );
				$( ".forgot_passwd_block" ).css( 'display','block' );
				var current_block = $( '.forgot_passwd_block' );
			} else {
				$( ".admin-form-content" ).css( 'display','none' );
				$( ".sign_register_block" ).css( 'display','block' );
				var current_block = $( '.sign_register_block' );
			}			
			$('.admin-form-block .title-form').addClass('back').removeClass('current');
			$(".admin-form-block .main_form_navigation #tab_"+this_id).addClass("current").removeClass('back');
			$('.admin-form-block .content-form').addClass("hidden");
			$('.admin-form-block #tab_' + this_id + "_content").removeClass('hidden');
			
			$( '.admin-form-block' ).css( 'margin-top', 0 );
			var current_height = ($(window).height() - current_block.outerHeight()) / 2;
			if ( current_height > 20 ) {
				$( '.admin-form-block' ).css( 'margin-top', current_height + $(window).scrollTop() + 'px' );
			} else {
				$( '.admin-form-block' ).css( 'margin-top', 20 + $(window).scrollTop() + 'px' );
			}
		});

		// navigation for faq page
		$(".faq_nav li").click(function(){
			$(".faq_nav li").removeClass('current');
			$( this ).addClass('current');
		});

		// change sorting for the "choose-car" page and reloading content
		$(".widget-title-sort a").click(function(){
			$(".widget-title-sort a").removeClass('current');
			$( this ).addClass('current');
			$(".content-overlay").css('display','block').css('height', $('.product-widget > form').height() ).css('width', $('.product-widget > form').width() );
			$(".content-overlay > img").css('display','block').css('margin-top', $('.product-widget > form').height()/2-33 ).css('margin-left', $('.product-widget > form').width()/2-33 );
			setTimeout(function () {
				$(".main-widget .close-details").css('display','none');
				$('.main-widget .view-details').css('display','block');
				$('.main-widget .details-more').css('display','none');
			    $(".content-overlay").css('display','none');
			}, 400);
		});

		// location checkbox - add block "Return location"
		$('.content-form .return_location').css('display','none');
		$("#location-checkbox, #location-checkbox-1").change( function() {
			if ( $( this ).is(':checked') ) {
				$('.return_location').css('display','block');
			} else {
				$('.return_location').css('display','none');
			}
		});
		$( "span.checkbox" ).live( 'click',function() {
			if ( $( this ).next('input[type="checkbox"]').attr('id') == 'location-checkbox' || $( this ).next('input[type="checkbox"]').attr('id') == 'location-checkbox-1' ) {
				
				if ( $( this ).next('input[type="checkbox"]').is(':checked') ) {
					$('.return_location').css('display','block');
				} else {
					$('.return_location').css('display','none');
				}
			}	
		});

		/* pagination and reloading content */
		$('.pagination div').click(function(){
			$('.pagination div').removeClass('current');
			$(".content-overlay").css('display','block').css('height', $('.product-widget > form').height() ).css('width', $('.product-widget > form').width() );
			$(".content-overlay > img").css('display','block').css('margin-top', $('.product-widget > form').height()/2-33 ).css('margin-left', $('.product-widget > form').width()/2-33 );
			if ( $( this ).hasClass( 'left' ) || $( this ).hasClass( 'right' ) ) {
				if ( $( this ).hasClass( 'left' ) ) {
					$( this ).next('div').addClass('current');
				} else {
					$( this ).prev('div').addClass('current');
				}
			} else {				
				$( this ).addClass('current');
			}
			setTimeout(function () {
				$(".main-widget .close-details").css('display','none');
				$('.main-widget .view-details').css('display','block');
				$('.main-widget .details-more').css('display','none');
			    $(".content-overlay").css('display','none');
			}, 400);
		});

		/* mobile menu */
		$( '.menu-icon' ).on( 'click', function() {
			if ( ! $( '.access-content > ul' ).is( ':visible' ) ) {
				$( '.access-content > ul' ).css( 'display', 'block' );
			}
		});
		$( '.menu-close span' ).click( function() {
			$( '#menu-icon' ).removeAttr( 'checked' );
			$( '.access-content > ul' ).css( 'display', 'none' );
		});
		if ( $( '.menu-icon' ).is( ':visible' ) ) {
			$( '.access-content > ul' ).height( $( 'body' ).height() );
		} else {
			$( '.access-content > ul' ).height( 'auto' );
		}		
	});
	$(window).resize( function () {
		if ( $( '.menu-icon' ).is( ':visible' ) ) {
			$( '.access-content > ul' ).height( $( 'body' ).height() );
		} else {
			$( '.access-content > ul' ).height( 'auto' );
		}
	});
})(jQuery);