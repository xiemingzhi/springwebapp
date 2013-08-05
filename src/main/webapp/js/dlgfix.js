function dialogCommonFix(oDialog)
{
	var p = oDialog.parent();

	//remove the upper-right corner [X]
	p.find('.ui-dialog-titlebar-close').remove();

	//remove the previous focus highlight on the buttons, if any
	p.find('div.ui-dialog-buttonset button').removeClass('ui-state-focus ui-state-hover ui-state-active').blur();

	//width & position problem workaround for IE6
	var ww = $(window).width();

	if (oDialog.width() >= (ww * 0.9))
	{
		//set its width to 0, and then get its scrollWidth
		oDialog.width(0).dialog('option', 'width', oDialog[0].scrollWidth);
		p.show(10, function(){ p.css('left', ((ww - p.outerWidth()) >> 1) + 'px'); });
	}
}

function dialogAutoCenter(oDialog, bMaintainWidth)
{
	if (!bMaintainWidth) oDialog.dialog('option', 'width', ~~($(window).width() / 355 * 113));
	var p = oDialog.parent();
	p.offset({
		left: ($(window).width() - p.outerWidth()) >> 1,
		top:  ($(window).height() - p.outerHeight()) >> 1
	});
}

function dialogGetButton(oDialog, buttonIdx)
{
	return oDialog.parent().find('div.ui-dialog-buttonset button:eq(' + buttonIdx + ')');
}
