package com.hexacta.weet.modules

/**
 * Pagination panel. 
 * <p> 
 * Following is an example of the html node that handles an instance of this class:<p>
<code> 
<div class="pagination">
	<div class="mensaje_pagination">
		<label>
			11 - 20
			de un total de 75
		</label>
	</div>
	<a href="/liquidacion-haberes/grado/list?offset=0&amp;max=10" class="prevLink">Anterior</a>
	<a href="/liquidacion-haberes/grado/list?offset=0&amp;max=10" class="step">1</a>
	<span class="currentStep">2</span>
	<a href="/liquidacion-haberes/grado/list?offset=20&amp;max=10" class="step">3</a>
	<a href="/liquidacion-haberes/grado/list?offset=20&amp;max=10" class="nextLink">Siguiente</a>
</div>
</code> 
 * @author gmassenzano
 */
class PaginationModule extends WeetModule {

	static content = {
		links(required: false) { $("a") }
		currentPage(required: false) { $(".currentStep")?.text()?.toInteger() ?: 1 }
		nextLink(required: false) { links.filter(".nextLink") }
		previousLink(required: false) { links.filter(".prevLink") }
	}

	/**
	 * It navigates to the page corresponding to the received number.
	 * 
	 * @param pageNumber
	 */
	void toPage(int pageNumber) {
		def link = links.filter(text: "$pageNumber")
		if (!link) throw new IllegalArgumentException("Page number $pageNumber not present in pagination")
		link.click()
	}

	/**
	 * It navigates to next page.
	 */
	void next() {
		if (lastPage) throw new IllegalStateException("Cannot go to next page from last page")
		nextLink.click()
	}

	/**
	 * It navigates to previous page.
	 */
	void previous() {
		if (firstPage) throw new IllegalStateException("Cannot go to previous page from first page")
		previousLink.click()
	}

	/**
	 * It returns true if current page is the first one. Otherwise, false.
	 */
	boolean isFirstPage() {
		previousLink.empty
	}

	/**
	 * It returns true if current page is the last one. Otherwise, false.
	 */
	boolean isLastPage() {
		nextLink.empty
	}
}
