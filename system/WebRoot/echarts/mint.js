/**
 * Created by Egg on 2016/4/8.
 */
define({
    // 鍏ㄥ浘榛樿鑳屾櫙
    // backgroundColor: 'rgba(0,0,0,0)',

    // 榛樿鑹叉澘
    color: ['#8aedd5','#93bc9e','#cef1db','#7fe579','#a6d7c2',
        '#bef0bb','#99e2vb','#94f8a8','#7de5b8','#4dfb70'],



    // 鍊煎煙
    dataRange: {
        color:['#93bc92','#bef0bb']
    },

    // K绾垮浘榛樿鍙傛暟
    k: {
        // barWidth : null          // 榛樿鑷€傚簲
        // barMaxWidth : null       // 榛樿鑷€傚簲
        itemStyle: {
            normal: {
                color: '#8aedd5',          // 闃崇嚎濉厖棰滆壊
                color0: '#7fe579',      // 闃寸嚎濉厖棰滆壊
                lineStyle: {
                    width: 1,
                    color: '#8aedd5',   // 闃崇嚎杈规棰滆壊
                    color0: '#7fe579'   // 闃寸嚎杈规棰滆壊
                }
            },
            emphasis: {
                // color: 鍚勫紓,
                // color0: 鍚勫紓
            }
        }
    },

    // 楗煎浘榛樿鍙傛暟
    pie: {
        itemStyle: {
            normal: {
                // color: 鍚勫紓,
                borderColor: '#fff',
                borderWidth: 1,
                label: {
                    show: true,
                    position: 'outer',
                    textStyle: {color: '#1b1b1b'},
                    lineStyle: {color: '#1b1b1b'}
                    // textStyle: null      // 榛樿浣跨敤鍏ㄥ眬鏂囨湰鏍峰紡锛岃瑙乀EXTSTYLE
                },
                labelLine: {
                    show: true,
                    length: 20,
                    lineStyle: {
                        // color: 鍚勫紓,
                        width: 1,
                        type: 'solid'
                    }
                }
            }
        }
    },

    map: {
        mapType: 'china',   // 鍚勭渷鐨刴apType鏆傛椂閮界敤涓枃
        mapLocation: {
            x : 'center',
            y : 'center'
            // width    // 鑷€傚簲
            // height   // 鑷€傚簲
        },
        showLegendSymbol : true,       // 鏄剧ず鍥句緥棰滆壊鏍囪瘑锛堢郴鍒楁爣璇嗙殑灏忓渾鐐癸級锛屽瓨鍦╨egend鏃剁敓鏁�
        itemStyle: {
            normal: {
                // color: 鍚勫紓,
                borderColor: '#fff',
                borderWidth: 1,
                areaStyle: {
                    color: '#ccc'//rgba(135,206,250,0.8)
                },
                label: {
                    show: false,
                    textStyle: {
                        color: 'rgba(139,69,19,1)'
                    }
                }
            },
            emphasis: {                 // 涔熸槸閫変腑鏍峰紡
                // color: 鍚勫紓,
                borderColor: 'rgba(0,0,0,0)',
                borderWidth: 1,
                areaStyle: {
                    color: '#f3f39d'
                },
                label: {
                    show: false,
                    textStyle: {
                        color: 'rgba(139,69,19,1)'
                    }
                }
            }
        }
    },

    force : {
        itemStyle: {
            normal: {
                // color: 鍚勫紓,
                label: {
                    show: false
                    // textStyle: null      // 榛樿浣跨敤鍏ㄥ眬鏂囨湰鏍峰紡锛岃瑙乀EXTSTYLE
                },
                nodeStyle : {
                    brushType : 'both',
                    strokeColor : '#49b485'
                },
                linkStyle : {
                    strokeColor : '#49b485'
                }
            },
            emphasis: {
                // color: 鍚勫紓,
                label: {
                    show: false
                    // textStyle: null      // 榛樿浣跨敤鍏ㄥ眬鏂囨湰鏍峰紡锛岃瑙乀EXTSTYLE
                },
                nodeStyle : {},
                linkStyle : {}
            }
        }
    },

    gauge : {
        axisLine: {            // 鍧愭爣杞寸嚎
            show: true,        // 榛樿鏄剧ず锛屽睘鎬how鎺у埗鏄剧ず涓庡惁
            lineStyle: {       // 灞炴€ineStyle鎺у埗绾挎潯鏍峰紡
                color: [[0.2, '#93bc9e'],[0.8, '#8aedd5'],[1, '#a6d7c2']],
                width: 8
            }
        },
        axisTick: {            // 鍧愭爣杞村皬鏍囪
            splitNumber: 10,   // 姣忎唤split缁嗗垎澶氬皯娈�
            length :12,        // 灞炴€ength鎺у埗绾块暱
            lineStyle: {       // 灞炴€ineStyle鎺у埗绾挎潯鏍峰紡
                color: 'auto'
            }
        },
        axisLabel: {           // 鍧愭爣杞存枃鏈爣绛撅紝璇﹁axis.axisLabel
            textStyle: {       // 鍏朵綑灞炴€ч粯璁や娇鐢ㄥ叏灞€鏂囨湰鏍峰紡锛岃瑙乀EXTSTYLE
                color: 'auto'
            }
        },
        splitLine: {           // 鍒嗛殧绾�
            length : 18,         // 灞炴€ength鎺у埗绾块暱
            lineStyle: {       // 灞炴€ineStyle锛堣瑙乴ineStyle锛夋帶鍒剁嚎鏉℃牱寮�
                color: 'auto'
            }
        },
        pointer : {
            length : '90%',
            color : 'auto'
        },
        title : {
            textStyle: {       // 鍏朵綑灞炴€ч粯璁や娇鐢ㄥ叏灞€鏂囨湰鏍峰紡锛岃瑙乀EXTSTYLE
                color: '#333'
            }
        },
        detail : {
            textStyle: {       // 鍏朵綑灞炴€ч粯璁や娇鐢ㄥ叏灞€鏂囨湰鏍峰紡锛岃瑙乀EXTSTYLE
                color: 'auto'
            }
        }
    }
});

