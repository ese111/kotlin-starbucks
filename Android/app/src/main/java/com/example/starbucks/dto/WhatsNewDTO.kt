package com.example.starbucks.dto

import android.util.Log
import androidx.annotation.Keep
import com.example.starbucks.common.getImageUrl
import com.example.starbucks.data.WhatsNewItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class WhatsNewDTO(
    @SerialName("cnt")
    val cnt: Int?,
    @SerialName("list")
    val list: List<Vo>?,
    @SerialName("vo")
    val vo: Vo?
) {
    @Keep
    @Serializable
    data class Vo(
        @SerialName("active_QUATER")
        val activeQUATER: String?,
        @SerialName("active_YEAR")
        val activeYEAR: String?,
        @SerialName("after_seq")
        val afterSeq: Int?,
        @SerialName("app_contn_btn_img_name")
        val appContnBtnImgName: String?,
        @SerialName("app_contn_btn_link_url")
        val appContnBtnLinkUrl: String?,
        @SerialName("app_contn_cntnt")
        val appContnCntnt: String?,
        @SerialName("app_contn_cntnt_img_name")
        val appContnCntntImgName: String?,
        @SerialName("app_thnl_img_name")
        val appThnlImgName: String?,
        @SerialName("app_yn")
        val appYn: String?,
        @SerialName("appyn")
        val appyn: String?,
        @SerialName("banner_type")
        val bannerType: String?,
        @SerialName("befor_seq")
        val beforSeq: Int?,
        @SerialName("cate")
        val cate: String?,
        @SerialName("cate_cd")
        val cateCd: String?,
        @SerialName("cate_nm")
        val cateNm: String?,
        @SerialName("content")
        val content: String?,
        @SerialName("contn_cntnt_xpsr_dvsn_code")
        val contnCntntXpsrDvsnCode: String?,
        @SerialName("contn_ctn_cntnt")
        val contnCtnCntnt: String?,
        @SerialName("csm_edt")
        val csmEdt: String?,
        @SerialName("csm_sdt")
        val csmSdt: String?,
        @SerialName("decode")
        val decode: String?,
        @SerialName("del_yn")
        val delYn: String?,
        @SerialName("departments")
        val departments: String?,
        @SerialName("endDate")
        val endDate: String?,
        @SerialName("end_dt")
        val endDt: String?,
        @SerialName("excel_Name")
        val excelName: String?,
        @SerialName("excel_yn")
        val excelYn: String?,
        @SerialName("fileName")
        val fileName: String?,
        @SerialName("file_nm")
        val fileNm: String?,
        @SerialName("file_nm1")
        val fileNm1: String?,
        @SerialName("file_nm2")
        val fileNm2: String?,
        @SerialName("file_nm3")
        val fileNm3: String?,
        @SerialName("file_type")
        val fileType: String?,
        @SerialName("firstIndex")
        val firstIndex: Int?,
        @SerialName("hit")
        val hit: Int?,
        @SerialName("img_nm")
        val imgNm: String?,
        @SerialName("img_nm_tag")
        val imgNmTag: String?,
        @SerialName("lastIndex")
        val lastIndex: String?,
        @SerialName("menu_cd")
        val menuCd: String?,
        @SerialName("message")
        val message: String?,
        @SerialName("mod_dt")
        val modDt: String?,
        @SerialName("mod_user")
        val modUser: String?,
        @SerialName("news_dt")
        val newsDt: String?,
        @SerialName("next_regdate")
        val nextRegdate: String?,
        @SerialName("next_seq")
        val nextSeq: Int?,
        @SerialName("next_title")
        val nextTitle: String?,
        @SerialName("order_num")
        val orderNum: Int?,
        @SerialName("pageIndex")
        val pageIndex: Int?,
        @SerialName("pageSize")
        val pageSize: Int?,
        @SerialName("page_status")
        val pageStatus: String?,
        @SerialName("pageType")
        val pageType: String?,
        @SerialName("pageUnit")
        val pageUnit: Int?,
        @SerialName("period_type")
        val periodType: String?,
        @SerialName("prev_regdate")
        val prevRegdate: String?,
        @SerialName("prev_seq")
        val prevSeq: Int?,
        @SerialName("prev_title")
        val prevTitle: String?,
        @SerialName("product_cd")
        val productCd: String?,
        @SerialName("recordCountPerPage")
        val recordCountPerPage: Int?,
        @SerialName("reg_dt")
        val regDt: String?,
        @SerialName("reg_user")
        val regUser: String?,
        @SerialName("resultBoolean")
        val resultBoolean: Boolean?,
        @SerialName("resultString")
        val resultString: String?,
        @SerialName("rnum")
        val rnum: Int?,
        @SerialName("row")
        val row: String?,
        @SerialName("sSeq")
        val sSeq: String?,
        @SerialName("san_content")
        val sanContent: String?,
        @SerialName("san_index")
        val sanIndex: Int?,
        @SerialName("san_openyn")
        val sanOpenyn: String?,
        @SerialName("san_regdate")
        val sanRegdate: String?,
        @SerialName("san_title")
        val sanTitle: String?,
        @SerialName("search")
        val search: String?,
        @SerialName("searchCondition")
        val searchCondition: String?,
        @SerialName("searchKey")
        val searchKey: String?,
        @SerialName("searchKeyword")
        val searchKeyword: String?,
        @SerialName("search_word")
        val searchWord: String?,
        @SerialName("search_word_type")
        val searchWordType: String?,
        @SerialName("seq")
        val seq: Int?,
        @SerialName("startDate")
        val startDate: String?,
        @SerialName("start_dt")
        val startDt: String?,
        @SerialName("status")
        val status: String?,
        @SerialName("statusPage")
        val statusPage: String?,
        @SerialName("store_code")
        val storeCode: String?,
        @SerialName("sub_title_name")
        val subTitleName: String?,
        @SerialName("tag_seq")
        val tagSeq: Int?,
        @SerialName("tag_txt")
        val tagTxt: String?,
        @SerialName("thum_img_yn")
        val thumImgYn: String?,
        @SerialName("thumbnail_nm")
        val thumbnailNm: String?,
        @SerialName("title")
        val title: String?,
        @SerialName("totalCnt")
        val totalCnt: Int?,
        @SerialName("view_ty")
        val viewTy: Int?,
        @SerialName("view_yn")
        val viewYn: String?,
        @SerialName("web_contn_btn_img_name")
        val webContnBtnImgName: String?,
        @SerialName("web_contn_btn_link_url")
        val webContnBtnLinkUrl: String?,
        @SerialName("web_contn_cntnt_img_name")
        val webContnCntntImgName: String?,
        @SerialName("web_contn_link_nwndw_yn")
        val webContnLinkNwndwYn: String?,
        @SerialName("web_yn")
        val webYn: String?,
        @SerialName("webxpsrseqc")
        val webxpsrseqc: String?,
        @SerialName("wmonth")
        val wmonth: String?,
        @SerialName("wyear")
        val wyear: String?
    )
}

fun WhatsNewDTO.toWhatsNewList(): List<WhatsNewItem> {
    val whatsNewList = mutableListOf<WhatsNewItem>()

    this.list?.forEach { whatsNew ->
        val title = requireNotNull(whatsNew.title)
        val regDate = whatsNew.newsDt.orEmpty()
        val image = whatsNew.imgNm?.let { getImageUrl(it) }.orEmpty()
        whatsNewList.add(WhatsNewItem(title, regDate, image))
    }

    return whatsNewList
}


