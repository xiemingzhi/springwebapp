
function clearDtSearchInput(search_input_selector)
{
	(!search_input_selector? $('input[aria-controls]') : $(search_input_selector)).val('').trigger('keyup.DT');
}


(function($){
	$.fn.originalDataTable = $.fn.DataTable;
	var newDT = function(oInit){
		var dt = $(this).originalDataTable(oInit);
		var elid = $(this).attr('id');
		for (var i = 0; i < $(this).DataTable.settings.length; i++)
		{
			var s = $(this).DataTable.settings[i];
			if (s.sTableId != elid) continue;
			s.fnModifyJsonReply = oInit.fnModifyJsonReply;
			s.fnCustomAjaxErrCallback = oInit.fnCustomAjaxErrCallback;
			s.fnCustomAjaxSuccessCallback = oInit.fnCustomAjaxSuccessCallback;
		}
		return dt;
	};

	$.extend(newDT, $.fn.DataTable);

	$.fn.DataTable = newDT;
	$.fn.dataTable = newDT;
	$.fn.dataTableSettings = newDT.settings;
	$.fn.dataTableExt = newDT.ext;
})(jQuery);
