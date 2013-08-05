function toggleInnerLayout()
{
	if (centerareaLayout && $("#centerarea").is(":visible"))
		showInnerLayout("emailEdit");
	else
		showInnerLayout("centerarea");
	return false; // cancel hyperlink
};


function showInnerLayout(name)
{
	var altName = name=="centerarea" ? "emailEdit" : "centerarea";
	$( "#"+ altName ).hide();	// hide OTHER layout container
	$( "#"+ name ).show();		// show THIS layout container
	// if layout is already initialized, then just resize it

	if (window[name + "Layout"])
		window[name + "Layout"].resizeAll();
	// otherwise init the layout the FIRST TIME
	else
		window[name + "Layout"] = $("#" + name).layout( window[ name + "LayoutOptions" ] ); // use per-layout options
		//window[ name +"Layout" ] = $("#"+ name).layout( innerLayoutOptions ); // use common options
};


function resizeInnerLayout()
{
	if (centerareaLayout && $("#centerarea").is(":visible"))
		centerareaLayout.resizeAll();
	else if (emailEditLayout && $("#emailEdit").is(":visible"))
		emailEditLayout.resizeAll();
};

var
outerLayout = null,
outerLayoutOptions = {
	center__paneSelector:	".outer-center",
	north__paneSelector:	".outer-north",
	spacing_open:			0,	// ALL panes
	spacing_closed:			0,	// ALL panes
	north__closable:		false,
	north__resizable:		false,
	north__spacing_open:	0,
	center__onresize:		resizeInnerLayout,
	south__closable:		false,
	south__resizable:		false
},

centerareaLayout = null,
centerareaLayoutOptions = {
	spacing_open:				1,	// ALL panes
	spacing_closed:				0,	// ALL panes
	west__closable:				false,
	west__resizable:			false,
	west__size:					240,
	west__minSize:				240,
	west__maxSize:				500,
	east__size:					200,
	east__minSize:				150,
	east__maxSize:				300,
	north__closable:			false,
	north__resizable:			false,
	north__spacing_open:		0,
	west__togglerLength_open:	0,
	east__togglerLength_open:	0,
	east__togglerLength_closed:	0,
	east__initClosed:			true,
	center__onresize:			"centerareaInnerLayout.resizeAll"
},

centerareaInnerLayout = null,
centerareaInnerLayoutOptions = {
	center__paneSelector:			".inner-center",
	south__paneSelector:			".inner-south",
	spacing_open:					8,
	spacing_closed:					8,
	south__size:					"80%",
	south__minSize:					"1%",
	south__maxSize:					"99%",
	south__togglerLength_open:		0,
	south__togglerLength_closed:	0,
	south__resizerTip:				"Resize",
	south__resizable: true,
	south__slidable: false,
	south__closable: false
//	south__closable: true,
//	south__onclose_start: function(pane, jElem, state, opts, layoutname){
//		return false;
//	}
},

emailEditLayout = null,
emailEditLayoutOptions = {
	spacing_open:			0,
	triggerEventsOnLoad:	true,
	center__onresize: function (pane, $Pane, state) {
			// Layout will set the TEXTAREA height, but must manually calculate and set the width
			var
				$TextArea	= $Pane.children('.ui-layout-content')
			,	outerWidth	= state.innerWidth // handle padding on the pane
			,	padding		= 2 * parseInt( $TextArea.css('paddingLeft') )
			,	border		= 2 * parseInt( $TextArea.css('borderLeftWidth') )
			;
			$TextArea.width( outerWidth - padding - border );
		}
};


function setnewsouth__size(south_size, south_minSize, south_maxSize)
{
	centerareaInnerLayoutOptions.south__size	= south_size;
	centerareaInnerLayoutOptions.south__minSize	= south_minSize;
	centerareaInnerLayoutOptions.south__maxSize	= south_maxSize;
};


function initLayout(south_size, south_min, south_max)
{
	// args are optional, and if given, set them
	if (south_size)
	{
		// Ignore the input value. Use browser window height to set the initial value.
		var w_height = $(window).height();
		var ini_south = "70%";
		if(w_height > 950) {
			ini_south = "85%";
		} else if(w_height > 900) {
			ini_south = "84%";
		} else if(w_height > 850) {
			ini_south = "83%";
		} else if(w_height > 800) {
			ini_south = "82%";
		} else if(w_height > 750) {
			ini_south = "81%";
		} else if(w_height > 700) {
			ini_south = "79%";
		} else if(w_height > 650) {
			ini_south = "77%";
		} else if(w_height > 600) {
			ini_south = "75%";
		}
//		setnewsouth__size(south_size, south_min, south_max);
		setnewsouth__size(ini_south, south_min, south_max);
	}

	outerLayout = $('body').layout(outerLayoutOptions);
	centerareaLayout = $('#centerarea').layout(centerareaLayoutOptions);
	centerareaInnerLayout = $('#centerarea .ui-layout-center').layout(centerareaInnerLayoutOptions);
};


//e.g. set_active_cube('cube_list'); 
function set_active_cube(cube_id)
{
	var menuitems = $("#top_area div");

	//highlight the menuitem 
	menuitems.filter(function(index){
		if ($(this).attr('id').toLowerCase() == cube_id.toLowerCase()) return true;
		return false;
	}).trigger('click');
}
