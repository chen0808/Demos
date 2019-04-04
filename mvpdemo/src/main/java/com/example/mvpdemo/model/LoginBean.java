package com.example.mvpdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginBean extends BaseBean {

    /**
     * userid : 100001
     * level : 1
     * type : 维修组
     */

    private String userid;
    private String level;
    private String type;
    /**
     * code : 0
     * msg : 请求成功！
     * result : {"taskActNdName":"2019年红外测温月历表","createdName":"管理员","monthly":"1,4,7,10","lineNo":"1121","lineName":"罗桃开三线","cTime":"2019-03-15","type":"红外测温","status":null,"dyLevel":"交流110kV","lineLevel":"180天","lId":"8D0AE7A4980C463B9E482C21D143156E","eqTowerList":[{"id":"768C311692AA4491A5E130E21C7517B3","name":"罗桃开三线001#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7953987","wd":"36.07984828","detail":"塔型FGU呼高15全高26.5","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":"1","tyTime":null,"bfTime":null,"status":"0"},{"id":"DB5AD73991A641F998B0866E3B3852A8","name":"罗桃开三线002#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7960735","wd":"36.08054734","detail":"塔型J2塔呼高15全高19","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".0987","tyTime":null,"bfTime":null,"status":"0"},{"id":"71DE7096FFB54C1EBB539BDA2F21F58A","name":"罗桃开三线003#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7961005","wd":"36.08086593","detail":"塔型JGU3塔呼高15全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".0355","tyTime":null,"bfTime":null,"status":"0"},{"id":"D3A113C9D32D448899A8CAE2D9BAB578","name":"罗桃开三线004#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7972121","wd":"36.08341779","detail":"塔型JGu2塔呼高18全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".3012","tyTime":null,"bfTime":null,"status":"0"},{"id":"8538ECE3C9314094AB30CE2AF492AF67","name":"罗桃开三线005#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7985516","wd":"36.08613907","detail":"塔型JGu2塔呼高15全高26","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".326","tyTime":null,"bfTime":null,"status":"0"},{"id":"95780F6E8BF04394BA76B3EDAE989D59","name":"罗桃开三线006#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7983865","wd":"36.08815506","detail":"塔型ZGU2呼高18全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".2249","tyTime":null,"bfTime":null,"status":"0"},{"id":"2BBFE47AA5BC4CEA89AC4392167AD39A","name":"罗桃开三线007#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7982155","wd":"36.08967409","detail":"塔型JGU3塔呼高12全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".1698","tyTime":null,"bfTime":null,"status":"0"}]}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * taskActNdName : 2019年红外测温月历表
         * createdName : 管理员
         * monthly : 1,4,7,10
         * lineNo : 1121
         * lineName : 罗桃开三线
         * cTime : 2019-03-15
         * type : 红外测温
         * status : null
         * dyLevel : 交流110kV
         * lineLevel : 180天
         * lId : 8D0AE7A4980C463B9E482C21D143156E
         * eqTowerList : [{"id":"768C311692AA4491A5E130E21C7517B3","name":"罗桃开三线001#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7953987","wd":"36.07984828","detail":"塔型FGU呼高15全高26.5","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":"1","tyTime":null,"bfTime":null,"status":"0"},{"id":"DB5AD73991A641F998B0866E3B3852A8","name":"罗桃开三线002#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7960735","wd":"36.08054734","detail":"塔型J2塔呼高15全高19","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".0987","tyTime":null,"bfTime":null,"status":"0"},{"id":"71DE7096FFB54C1EBB539BDA2F21F58A","name":"罗桃开三线003#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7961005","wd":"36.08086593","detail":"塔型JGU3塔呼高15全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".0355","tyTime":null,"bfTime":null,"status":"0"},{"id":"D3A113C9D32D448899A8CAE2D9BAB578","name":"罗桃开三线004#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7972121","wd":"36.08341779","detail":"塔型JGu2塔呼高18全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".3012","tyTime":null,"bfTime":null,"status":"0"},{"id":"8538ECE3C9314094AB30CE2AF492AF67","name":"罗桃开三线005#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7985516","wd":"36.08613907","detail":"塔型JGu2塔呼高15全高26","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".326","tyTime":null,"bfTime":null,"status":"0"},{"id":"95780F6E8BF04394BA76B3EDAE989D59","name":"罗桃开三线006#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7983865","wd":"36.08815506","detail":"塔型ZGU2呼高18全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".2249","tyTime":null,"bfTime":null,"status":"0"},{"id":"2BBFE47AA5BC4CEA89AC4392167AD39A","name":"罗桃开三线007#","lineId":"8D0AE7A4980C463B9E482C21D143156E","jd":"103.7982155","wd":"36.08967409","detail":"塔型JGU3塔呼高12全高29","tLand":"1","type":null,"height":null,"span":null,"tension":null,"rSpan":null,"angle":null,"sort":null,"xsRange":".1698","tyTime":null,"bfTime":null,"status":"0"}]
         */

        private String taskActNdName;
        private String createdName;
        private String monthly;
        private String lineNo;
        private String lineName;
        private String cTime;
        @SerializedName("type")
        private String typeX;
        private Object status;
        private String dyLevel;
        private String lineLevel;
        private String lId;
        private List<EqTowerListBean> eqTowerList;

        public String getTaskActNdName() {
            return taskActNdName;
        }

        public void setTaskActNdName(String taskActNdName) {
            this.taskActNdName = taskActNdName;
        }

        public String getCreatedName() {
            return createdName;
        }

        public void setCreatedName(String createdName) {
            this.createdName = createdName;
        }

        public String getMonthly() {
            return monthly;
        }

        public void setMonthly(String monthly) {
            this.monthly = monthly;
        }

        public String getLineNo() {
            return lineNo;
        }

        public void setLineNo(String lineNo) {
            this.lineNo = lineNo;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public String getCTime() {
            return cTime;
        }

        public void setCTime(String cTime) {
            this.cTime = cTime;
        }

        public String getTypeX() {
            return typeX;
        }

        public void setTypeX(String typeX) {
            this.typeX = typeX;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public String getDyLevel() {
            return dyLevel;
        }

        public void setDyLevel(String dyLevel) {
            this.dyLevel = dyLevel;
        }

        public String getLineLevel() {
            return lineLevel;
        }

        public void setLineLevel(String lineLevel) {
            this.lineLevel = lineLevel;
        }

        public String getLId() {
            return lId;
        }

        public void setLId(String lId) {
            this.lId = lId;
        }

        public List<EqTowerListBean> getEqTowerList() {
            return eqTowerList;
        }

        public void setEqTowerList(List<EqTowerListBean> eqTowerList) {
            this.eqTowerList = eqTowerList;
        }

        public static class EqTowerListBean {
            /**
             * id : 768C311692AA4491A5E130E21C7517B3
             * name : 罗桃开三线001#
             * lineId : 8D0AE7A4980C463B9E482C21D143156E
             * jd : 103.7953987
             * wd : 36.07984828
             * detail : 塔型FGU呼高15全高26.5
             * tLand : 1
             * type : null
             * height : null
             * span : null
             * tension : null
             * rSpan : null
             * angle : null
             * sort : null
             * xsRange : 1
             * tyTime : null
             * bfTime : null
             * status : 0
             */

            private String id;
            private String name;
            private String lineId;
            private String jd;
            private String wd;
            private String detail;
            private String tLand;
            @SerializedName("type")
            private Object typeX;
            private Object height;
            private Object span;
            private Object tension;
            private Object rSpan;
            private Object angle;
            private Object sort;
            private String xsRange;
            private Object tyTime;
            private Object bfTime;
            private String status;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLineId() {
                return lineId;
            }

            public void setLineId(String lineId) {
                this.lineId = lineId;
            }

            public String getJd() {
                return jd;
            }

            public void setJd(String jd) {
                this.jd = jd;
            }

            public String getWd() {
                return wd;
            }

            public void setWd(String wd) {
                this.wd = wd;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getTLand() {
                return tLand;
            }

            public void setTLand(String tLand) {
                this.tLand = tLand;
            }

            public Object getTypeX() {
                return typeX;
            }

            public void setTypeX(Object typeX) {
                this.typeX = typeX;
            }

            public Object getHeight() {
                return height;
            }

            public void setHeight(Object height) {
                this.height = height;
            }

            public Object getSpan() {
                return span;
            }

            public void setSpan(Object span) {
                this.span = span;
            }

            public Object getTension() {
                return tension;
            }

            public void setTension(Object tension) {
                this.tension = tension;
            }

            public Object getRSpan() {
                return rSpan;
            }

            public void setRSpan(Object rSpan) {
                this.rSpan = rSpan;
            }

            public Object getAngle() {
                return angle;
            }

            public void setAngle(Object angle) {
                this.angle = angle;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public String getXsRange() {
                return xsRange;
            }

            public void setXsRange(String xsRange) {
                this.xsRange = xsRange;
            }

            public Object getTyTime() {
                return tyTime;
            }

            public void setTyTime(Object tyTime) {
                this.tyTime = tyTime;
            }

            public Object getBfTime() {
                return bfTime;
            }

            public void setBfTime(Object bfTime) {
                this.bfTime = bfTime;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }
        }
    }
}
